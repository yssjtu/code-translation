import torch.nn as nn
import torch
import torch.nn.functional as F
from torch.nn import CrossEntropyLoss
import numpy as np
from transformers import (RobertaConfig, RobertaModel, RobertaTokenizer,
                          BartConfig, BartForConditionalGeneration, BartTokenizer,
                          T5Config, T5ForConditionalGeneration, T5Tokenizer)
# from transformers.models.t5.modeling_t5
# from transformers.models.mbart.modeling_mbart
import logging

logger = logging.getLogger(__name__)

MODEL_CLASSES = {'roberta': (RobertaConfig, RobertaModel, RobertaTokenizer),
                 't5': (T5Config, T5ForConditionalGeneration, T5Tokenizer),
                 'codet5': (T5Config, T5ForConditionalGeneration, RobertaTokenizer),
                 'bart': (BartConfig, BartForConditionalGeneration, BartTokenizer)}


class PromptEncoder(torch.nn.Module):
    '''
    https://github.com/THUDM/P-tuning/blob/main/LAMA/p_tuning/prompt_encoder.py
    '''

    def __init__(self, prompt_len, init_embedding):
        super().__init__()
        # embedding
        # self.embedding = torch.nn.Embedding(prompt_len, init_embedding.embedding_dim)
        self.wte=init_embedding
        self.prompt_len=prompt_len
        # for param in self.wte.parameters():
        #     param.requires_grad = False
        # with torch.no_grad():
        #
        #     # self.embedding.weight[0, :] = 0
        #     self.embedding.weight[0:prompt_len, :] = init_embedding.weight[5:prompt_len + 5, :].data

        self.softprompt_embed=nn.parameter.Parameter(self.wte.weight[1000:prompt_len+1000].clone().detach())

    def forward(self, input_ids=None):

        input_embedding = self.wte(input_ids[:,self.prompt_len:])

        # input_embedding=input_embedding[:,:input_embedding.shape[1]-prompt_len,:]
        learned_embedding = self.softprompt_embed.repeat(input_embedding.size(0), 1, 1)
        return torch.cat([learned_embedding, input_embedding], 1)


class PrefixEncoder(torch.nn.Module):
    '''
    https://github.com/XiangLi1999/PrefixTuning/blob/master/transformers/examples/control/train_control.py
    '''

    def __init__(self, num_trigs, config, init_embedding, mid_dim):
        super().__init__()
        self.num_trigs=num_trigs
        self.config = config
        # ent embedding
        self.seq_indices = torch.arange(num_trigs).long()
        # embedding
        self.embedding = torch.nn.Embedding(num_trigs, config.hidden_size)
        with torch.no_grad():
            self.embedding.weight[:num_trigs, :] = init_embedding.weight[1000:num_trigs + 1000, :].data
        # self.embedding = nn.Embedding.from_pretrained(init_embedding.weight.data, freeze=False)

        self.control_trans = nn.Sequential(
            nn.Linear(config.hidden_size, mid_dim),
            nn.Tanh(),
            nn.Linear(mid_dim, config.num_hidden_layers * 2 * config.hidden_size)
        )

    def forward(self, batch_size):
        device = self.embedding.weight.device

        input_tokens = self.seq_indices.unsqueeze(0).expand(batch_size, -1).to(device)
        temp_control = self.embedding(input_tokens)
        past_key_values = self.control_trans(temp_control)  # bsz, seqlen, layer*2*n_head*emb
        bsz, seqlen, _ = past_key_values.shape
        past_key_values = past_key_values.view(bsz, seqlen, self.config.num_hidden_layers * 2, self.config.num_attention_heads,
                                               self.config.hidden_size // self.config.num_attention_heads)
        # past_key_values = self.dropout(past_key_values)
        past_key_values = past_key_values.permute([2, 0, 3, 1, 4]).split(2)
        # a list of num_layers tensors, with each of a size [2, batch_size, num_heads, seq_len, embed_size_per_head]
        return past_key_values

class PrefixDecoder(torch.nn.Module):
    '''
    prefix used in T5ForConditionalGeneration decoder
    In T5 decoder, past_key_values[0:2] is used for self_attn and past_key_values[2:] for cross_attn.
    To ensure we only leverage past_key_values in self_attn module(i.e. adding prefix to decoder inputs),
    we need to manually calculate past_key_values[-2:] in cross_attn as following:
            copied from RobertaSelfAttention in modeling_roberta.py
            if is_cross_attention and past_key_value is not None:
             # reuse k,v, cross_attentions
                 key_layer = past_key_value[0]
                 value_layer = past_key_value[1]
                attention_mask = encoder_attention_mask
            elif is_cross_attention:
                 key_layer = self.transpose_for_scores(self.key(encoder_hidden_states))
                 value_layer = self.transpose_for_scores(self.value(encoder_hidden_states))
                attention_mask = encoder_attention_mask
    '''

    def __init__(self, num_trigs, config, init_embedding, mid_dim):
        super().__init__()
        self.config = config
        self.num_trigs=num_trigs

        #copied from modeling_roberta.py RobertaSelfAttention
        # self.num_attention_heads = config.num_attention_heads
        # self.attention_head_size = int(config.hidden_size / config.num_attention_heads)
        # self.all_head_size = self.num_attention_heads * self.attention_head_size

        # self.key = nn.Linear(config.hidden_size, self.all_head_size)
        # self.value = nn.Linear(config.hidden_size, self.all_head_size)
        #
        # self.key_layers = nn.ModuleList([nn.Linear(config.hidden_size,self.all_head_size) for _ in range(config.num_hidden_layers)])
        #
        # self.value_layers = nn.ModuleList([nn.Linear(config.hidden_size,self.all_head_size) for _ in range(config.num_hidden_layers)])


        # ent embedding
        self.seq_indices = torch.arange(num_trigs).long()
        # embedding
        self.embedding = torch.nn.Embedding(num_trigs, config.hidden_size)
        with torch.no_grad():
            self.embedding.weight[:num_trigs, :] = init_embedding.weight[1000:num_trigs + 1000, :].data
        # self.embedding = nn.Embedding.from_pretrained(init_embedding.weight.data, freeze=False)

        self.control_trans = nn.Sequential(
            nn.Linear(config.hidden_size, mid_dim),
            nn.Tanh(),
            nn.Linear(mid_dim, config.num_hidden_layers * 2 * config.hidden_size)
        )





    def forward(self, batch_size,encoder_hidden_states,decoder):
        # copied from modeling_T5.py .T5Attention
        def shape(states,self):
            """projection"""
            return states.view(batch_size, -1, self.n_heads, self.key_value_proj_dim).transpose(1, 2)
        device = self.embedding.weight.device

        input_tokens = self.seq_indices.unsqueeze(0).expand(batch_size, -1).to(device)
        temp_control = self.embedding(input_tokens)
        past_key_values = self.control_trans(temp_control)  # bsz, seqlen, layer*2*n_head*emb
        bsz, seqlen, _ = past_key_values.shape
        past_key_values = past_key_values.view(bsz, seqlen, self.config.num_hidden_layers * 2,
                                               self.config.num_attention_heads,
                                               self.config.hidden_size // self.config.num_attention_heads)
        # past_key_values = self.dropout(past_key_values)
        past_key_values = past_key_values.permute([2, 0, 3, 1, 4]).split(2)
        # key_layer = self.transpose_for_scores(self.key(encoder_hidden_states))
        # value_layer = self.transpose_for_scores(self.value(encoder_hidden_states))
        prefix_out=[]
        for idx,past_key_value in enumerate(past_key_values):
            out=[]
            out.append(past_key_value[0])
            out.append(past_key_value[1])
            layer=decoder.block[idx].layer[1].EncDecAttention
            key=shape(layer.k(encoder_hidden_states),layer)
            value=shape(layer.v(encoder_hidden_states),layer)
            out.append(key)
            out.append(value)
            prefix_out.append(out)



        # a list of num_layers tensors, with each of a size [4, batch_size, num_heads, seq_len, embed_size_per_head],
        # first 2 for past_key_values in self-attn, last 2 in cross-attn
        return prefix_out
class Codet5_prefix(torch.nn.Module):
    def __init__(self,model,num_trigs, config, init_embedding, mid_dim):
        super().__init__()
        self.config=config
        self.codet5_model=model
        self.prefix_encoder=PrefixEncoder(num_trigs,config,init_embedding,mid_dim)
        self.prefix_encoder.to(model.device)
    def forward(self,input_ids, attention_mask,labels, decoder_attention_mask,return_dict=None):
        return_dict = return_dict if return_dict is not None else self.config.use_return_dict
        batch_size,seq_len=input_ids.size()
        past_key_values=self.prefix_encoder(batch_size)

        prompt_mask = torch.ones(attention_mask.shape[0], self.prefix_encoder.num_trigs).long().to(attention_mask.device)
        prefix_mask = torch.cat([prompt_mask, attention_mask], 1)

        encoder_outputs = self.codet5_model.encoder(
            past_key_values=past_key_values,
            input_ids=input_ids,
            attention_mask=prefix_mask,
            # attention_mask=attention_mask,
            return_dict=return_dict,
        )
        outputs= self.codet5_model(encoder_outputs=encoder_outputs,
                                   # input_ids=input_ids,
                                   attention_mask=attention_mask,
                                    labels=labels,
                                   decoder_attention_mask=decoder_attention_mask)
        return outputs
    def generate(self,source_ids,attention_mask,use_cache,num_beams,early_stopping,max_length,return_dict=None):
        return_dict = return_dict if return_dict is not None else self.config.use_return_dict
        batch_size, seq_len = source_ids.size()
        past_key_values = self.prefix_encoder(batch_size)

        prompt_mask = torch.ones(attention_mask.shape[0], self.prefix_encoder.num_trigs).long().to(attention_mask.device)
        prefix_mask = torch.cat([prompt_mask, attention_mask], 1)

        encoder_outputs = self.codet5_model.encoder(
            past_key_values=past_key_values,
            input_ids=source_ids,
            attention_mask=prefix_mask,
            # attention_mask=attention_mask,
            return_dict=return_dict,
        )
        outputs=self.codet5_model.generate(
            # source_ids,
                                        encoder_outputs=encoder_outputs,
                                        attention_mask=attention_mask,
                                        use_cache=use_cache,
                                        num_beams=num_beams,
                                        early_stopping=early_stopping,
                                        max_length=max_length)
        return outputs

class Codet5_decoder_prefix(torch.nn.Module):
    def __init__(self,model,num_trigs, config, init_embedding, mid_dim):
        super().__init__()
        self.config=config
        self.codet5_model=model
        self.prefix_decoder=PrefixDecoder(num_trigs,config,init_embedding,mid_dim)
        self.prefix_decoder.to(model.device)
    def forward(self,input_ids, attention_mask,labels, decoder_attention_mask,return_dict=None):
        return_dict = return_dict if return_dict is not None else self.config.use_return_dict
        batch_size,seq_len=input_ids.size()
        # past_key_values=self.prefix_encoder(batch_size)
        #
        # prompt_mask = torch.ones(attention_mask.shape[0], self.prefix_encoder.num_trigs).long().to(attention_mask.device)
        # prefix_mask = torch.cat([prompt_mask, attention_mask], 1)

        encoder_outputs = self.codet5_model.encoder(
            # past_key_values=past_key_values,
            input_ids=input_ids,
            attention_mask=attention_mask,
            # attention_mask=attention_mask,
            return_dict=return_dict,
        )

        decoder_prompt_mask = torch.ones(decoder_attention_mask.shape[0], self.prefix_decoder.num_trigs).long().to(decoder_attention_mask.device)
        decoder_prefix_mask = torch.cat([decoder_prompt_mask, decoder_attention_mask], 1)
        decoder_prompt_embed = self.prefix_decoder(batch_size, encoder_outputs[0], self.codet5_model.decoder)

        outputs= self.codet5_model(encoder_outputs=encoder_outputs,
                                   # input_ids=input_ids,
                                   attention_mask=attention_mask,
                                   labels=labels,
                                   decoder_attention_mask=decoder_prefix_mask,
                                   past_key_values=decoder_prompt_embed,
                                   use_cache=False)
        return outputs

    def generate(self,source_ids,attention_mask,use_cache,num_beams,early_stopping,max_length,return_dict=None):
        return_dict = return_dict if return_dict is not None else self.config.use_return_dict
        batch_size, seq_len = source_ids.size()
        # past_key_values = self.prefix_encoder(batch_size)
        #
        # prompt_mask = torch.ones(attention_mask.shape[0], self.prefix_encoder.num_trigs).long().to(attention_mask.device)
        # prefix_mask = torch.cat([prompt_mask, attention_mask], 1)

        encoder_outputs = self.codet5_model.encoder(
            # past_key_values=past_key_values,
            input_ids=source_ids,
            attention_mask=attention_mask,
            # attention_mask=attention_mask,
            return_dict=return_dict,
        )


        # input_ids, model_kwargs = self._expand_inputs_for_generation(
        #         input_ids, expand_size=num_beams, is_encoder_decoder=self.config.is_encoder_decoder, **model_kwargs
        #     )

        # def _expand_inputs_for_generation(
        #         input_ids: torch.LongTensor,
        #         expand_size: int = 1,
        #         is_encoder_decoder: bool = False,
        #         attention_mask: torch.LongTensor = None,
        #         encoder_outputs: ModelOutput = None,
        #         **model_kwargs,
        # ) -> Tuple[torch.LongTensor, Dict[str, Any]]:
        #     expanded_return_idx = (
        #         torch.arange(input_ids.shape[0]).view(-1, 1).repeat(1, expand_size).view(-1).to(input_ids.device)
        #     )
        #     input_ids = input_ids.index_select(0, expanded_return_idx)
        #
        #     if "token_type_ids" in model_kwargs:
        #         token_type_ids = model_kwargs["token_type_ids"]
        #         model_kwargs["token_type_ids"] = token_type_ids.index_select(0, expanded_return_idx)
        #
        #     if attention_mask is not None:
        #         model_kwargs["attention_mask"] = attention_mask.index_select(0, expanded_return_idx)
        #
        #     if is_encoder_decoder:
        #         assert encoder_outputs is not None
        #         encoder_outputs["last_hidden_state"] = encoder_outputs.last_hidden_state.index_select(
        #             0, expanded_return_idx.to(encoder_outputs.last_hidden_state.device)
        #         )
        #         model_kwargs["encoder_outputs"] = encoder_outputs
        #     return input_ids, model_kwargs

        expanded_return_idx = (
                torch.arange(source_ids.shape[0]).view(-1, 1).repeat(1, num_beams).view(-1).to(source_ids.device)
            )

        # encoder_outputs["last_hidden_state"] = encoder_outputs.last_hidden_state.index_select(
        #                 0, expanded_return_idx.to(encoder_outputs.last_hidden_state.device)
        #             )
        decoder_prompt_embed = self.prefix_decoder(num_beams*batch_size, encoder_outputs.last_hidden_state.index_select(
                        0, expanded_return_idx.to(encoder_outputs.last_hidden_state.device)
                    ), self.codet5_model.decoder)


        outputs=self.codet5_model.generate(
            # source_ids,
            encoder_outputs=encoder_outputs,
            # past_key_values=decoder_prompt_embed,
            past=decoder_prompt_embed,
            attention_mask=attention_mask,
            use_cache=use_cache,
            num_beams=num_beams,
            early_stopping=early_stopping,
            max_length=max_length
        )
        return outputs

class Codet5_encoder_decoder_prefix(torch.nn.Module):
    def __init__(self, model, num_trigs, config, init_embedding, mid_dim):
        super().__init__()
        self.config = config
        self.codet5_model = model
        self.prefix_encoder = PrefixEncoder(num_trigs, config, init_embedding, mid_dim)
        self.prefix_encoder.to(model.device)
        self.prefix_decoder = PrefixDecoder(num_trigs, config, init_embedding, mid_dim)
        self.prefix_decoder.to(model.device)

    def forward(self, input_ids, attention_mask, labels, decoder_attention_mask, return_dict=None):
        return_dict = return_dict if return_dict is not None else self.config.use_return_dict
        batch_size, seq_len = input_ids.size()
        past_key_values=self.prefix_encoder(batch_size)

        prompt_mask = torch.ones(attention_mask.shape[0], self.prefix_encoder.num_trigs).long().to(attention_mask.device)
        prefix_mask = torch.cat([prompt_mask, attention_mask], 1)

        encoder_outputs = self.codet5_model.encoder(
            past_key_values=past_key_values,
            input_ids=input_ids,
            attention_mask=prefix_mask,
            # attention_mask=attention_mask,
            return_dict=return_dict,
        )

        decoder_prompt_mask = torch.ones(decoder_attention_mask.shape[0], self.prefix_decoder.num_trigs).long().to(
            decoder_attention_mask.device)
        decoder_prefix_mask = torch.cat([decoder_prompt_mask, decoder_attention_mask], 1)
        decoder_prompt_embed = self.prefix_decoder(batch_size, encoder_outputs[0], self.codet5_model.decoder)

        outputs = self.codet5_model(encoder_outputs=encoder_outputs,
                                    # input_ids=input_ids,
                                    attention_mask=attention_mask,
                                    labels=labels,
                                    decoder_attention_mask=decoder_prefix_mask,
                                    past_key_values=decoder_prompt_embed,
                                    
                                    use_cache=False
                                    )
        return outputs

    def generate(self, source_ids, attention_mask, use_cache, num_beams, early_stopping, max_length, return_dict=None):
        return_dict = return_dict if return_dict is not None else self.config.use_return_dict
        batch_size, seq_len = source_ids.size()
        past_key_values = self.prefix_encoder(batch_size)

        prompt_mask = torch.ones(attention_mask.shape[0], self.prefix_encoder.num_trigs).long().to(attention_mask.device)
        prefix_mask = torch.cat([prompt_mask, attention_mask], 1)

        encoder_outputs = self.codet5_model.encoder(
            past_key_values=past_key_values,
            input_ids=source_ids,
            attention_mask=prefix_mask,
            # attention_mask=attention_mask,
            return_dict=return_dict,
        )


        # input_ids, model_kwargs = self._expand_inputs_for_generation(
        #         input_ids, expand_size=num_beams, is_encoder_decoder=self.config.is_encoder_decoder, **model_kwargs
        #     )

        # def _expand_inputs_for_generation(
        #         input_ids: torch.LongTensor,
        #         expand_size: int = 1,
        #         is_encoder_decoder: bool = False,
        #         attention_mask: torch.LongTensor = None,
        #         encoder_outputs: ModelOutput = None,
        #         **model_kwargs,
        # ) -> Tuple[torch.LongTensor, Dict[str, Any]]:
        #     expanded_return_idx = (
        #         torch.arange(input_ids.shape[0]).view(-1, 1).repeat(1, expand_size).view(-1).to(input_ids.device)
        #     )
        #     input_ids = input_ids.index_select(0, expanded_return_idx)
        #
        #     if "token_type_ids" in model_kwargs:
        #         token_type_ids = model_kwargs["token_type_ids"]
        #         model_kwargs["token_type_ids"] = token_type_ids.index_select(0, expanded_return_idx)
        #
        #     if attention_mask is not None:
        #         model_kwargs["attention_mask"] = attention_mask.index_select(0, expanded_return_idx)
        #
        #     if is_encoder_decoder:
        #         assert encoder_outputs is not None
        #         encoder_outputs["last_hidden_state"] = encoder_outputs.last_hidden_state.index_select(
        #             0, expanded_return_idx.to(encoder_outputs.last_hidden_state.device)
        #         )
        #         model_kwargs["encoder_outputs"] = encoder_outputs
        #     return input_ids, model_kwargs

        expanded_return_idx = (
            torch.arange(source_ids.shape[0]).view(-1, 1).repeat(1, num_beams).view(-1).to(source_ids.device)
        )

        # encoder_outputs["last_hidden_state"] = encoder_outputs.last_hidden_state.index_select(
        #                 0, expanded_return_idx.to(encoder_outputs.last_hidden_state.device)
        #             )
        decoder_prompt_embed = self.prefix_decoder(num_beams * batch_size,
                                                   encoder_outputs.last_hidden_state.index_select(
                                                       0,
                                                       expanded_return_idx.to(encoder_outputs.last_hidden_state.device)
                                                   ), self.codet5_model.decoder)


        outputs = self.codet5_model.generate(
            # source_ids,
            encoder_outputs=encoder_outputs,
            # past_key_values=decoder_prompt_embed,
            past=decoder_prompt_embed,
            attention_mask=attention_mask,
            use_cache=use_cache,
            num_beams=num_beams,
            early_stopping=early_stopping,
            max_length=max_length
        )
        return outputs
def freeze_codet5(model):
    for name,param in model.named_parameters():

        #if("shared." not in name):
            param.requires_grad = False

def add_soft_prompt(model,prompt_len):
    logger.info("prompt_len: "+str(prompt_len))
    logger.info("change original t5 embeddings to soft-prompt encoder...")
    prompt_encoder=PromptEncoder(prompt_len,model.get_input_embeddings())
    #only need to add softprompt in t5 encoder.
    model.encoder.set_input_embeddings(prompt_encoder)

def gen_prompt_id_and_mask(source_ids,source_mask,prompt_len):
    prompt_pad=torch.zeros(source_ids.shape[0], prompt_len).long().to(source_ids.device)
    prompt_mask = torch.ones(source_mask.shape[0], prompt_len).long().to(source_mask.device)
    # since we add #prompt_len prompt tokens ahead of input,accordingly adding source mask（1 for not masked，0 for masked）

    # source_mask = torch.cat([prompt_mask, source_mask], 1)

    source_ids=torch.cat([prompt_pad, source_ids], 1)
    source_mask=torch.cat([prompt_mask, source_mask], 1)
    return source_ids,source_mask

def gen_prefix(source_ids,source_mask,prompt_len):
    prompt_pad=torch.zeros(source_ids.shape[0], prompt_len).long().to(source_ids.device)
    prompt_mask = torch.ones(source_mask.shape[0], prompt_len).long().to(source_mask.device)
    # since we add #prompt_len prompt tokens ahead of input,accordingly adding source mask（1 for not masked，0 for masked）
    # source_mask = torch.cat([prompt_mask, source_mask], 1)

    source_ids=torch.cat([prompt_pad, source_ids], 1)
    source_mask=torch.cat([prompt_mask, source_mask], 1)
    return source_ids,source_mask

def load_codet5(config, model, tokenizer_class, load_extra_ids=True, add_lang_ids=False,
                tokenizer_path='/mnt/sda/ys/codeT5/CodeT5/tokenizer/salesforce'):
    vocab_fn = '{}/codet5-vocab.json'.format(tokenizer_path)
    merge_fn = '{}/codet5-merges.txt'.format(tokenizer_path)
    tokenizer = tokenizer_class(vocab_fn, merge_fn)

    tokenizer.add_special_tokens(
        {'additional_special_tokens': [
            "<pad>",
            "<s>",
            "</s>",
            "<unk>",
            "<mask>"
        ]})
    if load_extra_ids:
        tokenizer.add_special_tokens(
            {'additional_special_tokens': ['<extra_id_{}>'.format(i) for i in range(99, -1, -1)]})
    if add_lang_ids:
        tokenizer.add_special_tokens({'additional_special_tokens': ['<en>', '<python>', '<java>', '<javascript>',
                                                                    '<ruby>', '<php>', '<go>', '<c>', '<c_sharp>']})
    # pdb.set_trace()
    tokenizer.model_max_len = 512
    config.num_labels = 1
    config.vocab_size = len(tokenizer)
    config.pad_token_id = 0
    config.bos_token_id = 1
    config.eos_token_id = 2

    model.config = config  # changing the default eos_token_id from 1 to 2
    model.resize_token_embeddings(len(tokenizer))
    return config, model, tokenizer


def get_model_size(model):
    model_parameters = filter(lambda p: p.requires_grad, model.parameters())
    model_size = sum([np.prod(p.size()) for p in model_parameters])
    return "{}M".format(round(model_size / 1e+6))


def build_or_load_gen_model(args):
    config_class, model_class, tokenizer_class = MODEL_CLASSES[args.model_type]
    config = config_class.from_pretrained(args.config_name if args.config_name else args.model_name_or_path)
    if args.model_type != 'codet5':
        tokenizer = tokenizer_class.from_pretrained(args.tokenizer_name)
    if args.model_type == 'roberta':
        encoder = model_class.from_pretrained(args.model_name_or_path, config=config)
        decoder_layer = nn.TransformerDecoderLayer(d_model=config.hidden_size, nhead=config.num_attention_heads)
        decoder = nn.TransformerDecoder(decoder_layer, num_layers=6)
        model = Seq2Seq(encoder=encoder, decoder=decoder, config=config,
                        beam_size=args.beam_size, max_length=args.max_target_length,
                        sos_id=tokenizer.cls_token_id, eos_id=tokenizer.sep_token_id)
    else:
        model = model_class.from_pretrained(args.model_name_or_path)

    if args.model_type == 'codet5':
        # reset special ids: pad_token_id = 0, bos_token_id = 1, eos_token_id = 2
        config, model, tokenizer = load_codet5(config, model, tokenizer_class,
                                               add_lang_ids=args.add_lang_ids,
                                               tokenizer_path=args.tokenizer_path)
    logger.info("Finish loading model [%s] from %s", get_model_size(model), args.model_name_or_path)

    # if args.load_model_path is not None and args.LMadaption==2:
    #     logger.info("Reload model from {}".format(args.load_model_path))
    #     model.load_state_dict(torch.load(args.load_model_path))

    return config, model, tokenizer


class RobertaClassificationHead(nn.Module):
    """Head for sentence-level classification tasks."""

    def __init__(self, config):
        super().__init__()
        self.dense = nn.Linear(config.hidden_size * 2, config.hidden_size)
        self.out_proj = nn.Linear(config.hidden_size, 2)

    def forward(self, x, **kwargs):
        x = x.reshape(-1, x.size(-1) * 2)
        x = self.dense(x)
        x = torch.tanh(x)
        x = self.out_proj(x)
        return x


class CloneModel(nn.Module):
    def __init__(self, encoder, config, tokenizer, args):
        super(CloneModel, self).__init__()
        self.encoder = encoder
        self.config = config
        self.tokenizer = tokenizer
        self.classifier = RobertaClassificationHead(config)
        self.args = args

    def forward(self, source_ids=None, labels=None):
        source_ids = source_ids.view(-1, self.args.block_size)

        attention_mask = source_ids.ne(self.tokenizer.pad_token_id)
        outputs = self.encoder(input_ids=source_ids, attention_mask=attention_mask,
                               labels=source_ids, decoder_attention_mask=attention_mask, output_hidden_states=True)
        hidden_states = outputs['decoder_hidden_states'][-1]
        eos_mask = source_ids.eq(self.config.eos_token_id)

        if len(torch.unique(eos_mask.sum(1))) > 1:
            raise ValueError("All examples must have the same number of <eos> tokens.")
        vec = hidden_states[eos_mask, :].view(hidden_states.size(0), -1,
                                              hidden_states.size(-1))[:, -1, :]

        logits = self.classifier(vec)
        prob = F.softmax(logits)
        if labels is not None:
            loss_fct = CrossEntropyLoss()
            loss = loss_fct(logits, labels)
            return loss, prob
        else:
            return prob


# https://github.com/microsoft/CodeBERT/blob/master/CodeBERT/code2nl/model.py
class Seq2Seq(nn.Module):
    """
        Build Seqence-to-Sequence.

        Parameters:

        * `encoder`- encoder of seq2seq model. e.g. roberta
        * `decoder`- decoder of seq2seq model. e.g. transformer
        * `config`- configuration of encoder model.
        * `beam_size`- beam size for beam search.
        * `max_length`- max length of target for beam search.
        * `sos_id`- start of symbol ids in target for beam search.
        * `eos_id`- end of symbol ids in target for beam search.
    """

    def __init__(self, encoder, decoder, config, beam_size=None, max_length=None, sos_id=None, eos_id=None):
        super(Seq2Seq, self).__init__()
        self.encoder = encoder
        self.decoder = decoder
        self.config = config
        self.register_buffer("bias", torch.tril(torch.ones(2048, 2048)))
        self.dense = nn.Linear(config.hidden_size, config.hidden_size)
        self.lm_head = nn.Linear(config.hidden_size, config.vocab_size, bias=False)
        self.lsm = nn.LogSoftmax(dim=-1)
        self.tie_weights()

        self.beam_size = beam_size
        self.max_length = max_length
        self.sos_id = sos_id
        self.eos_id = eos_id

    def _tie_or_clone_weights(self, first_module, second_module):
        """ Tie or clone module weights depending of weither we are using TorchScript or not
        """
        if self.config.torchscript:
            first_module.weight = nn.Parameter(second_module.weight.clone())
        else:
            first_module.weight = second_module.weight

    def tie_weights(self):
        """ Make sure we are sharing the input and output embeddings.
            Export to TorchScript can't handle parameter sharing so we are cloning them instead.
        """
        self._tie_or_clone_weights(self.lm_head,
                                   self.encoder.embeddings.word_embeddings)

    def forward(self, source_ids=None, source_mask=None, target_ids=None, target_mask=None, args=None):
        outputs = self.encoder(source_ids, attention_mask=source_mask)
        encoder_output = outputs[0].permute([1, 0, 2]).contiguous()
        if target_ids is not None:
            attn_mask = -1e4 * (1 - self.bias[:target_ids.shape[1], :target_ids.shape[1]])
            tgt_embeddings = self.encoder.embeddings(target_ids).permute([1, 0, 2]).contiguous()
            out = self.decoder(tgt_embeddings, encoder_output, tgt_mask=attn_mask,
                               memory_key_padding_mask=~source_mask)
            # memory_key_padding_mask=(1 - source_mask).bool())
            hidden_states = torch.tanh(self.dense(out)).permute([1, 0, 2]).contiguous()
            lm_logits = self.lm_head(hidden_states)
            # Shift so that tokens < n predict n
            active_loss = target_mask[..., 1:].ne(0).view(-1) == 1
            shift_logits = lm_logits[..., :-1, :].contiguous()
            shift_labels = target_ids[..., 1:].contiguous()
            # Flatten the tokens
            loss_fct = nn.CrossEntropyLoss(ignore_index=-1)
            loss = loss_fct(shift_logits.view(-1, shift_logits.size(-1))[active_loss],
                            shift_labels.view(-1)[active_loss])

            outputs = loss, loss * active_loss.sum(), active_loss.sum()
            return outputs
        else:
            # Predict
            preds = []
            zero = torch.cuda.LongTensor(1).fill_(0)
            for i in range(source_ids.shape[0]):
                context = encoder_output[:, i:i + 1]
                context_mask = source_mask[i:i + 1, :]
                beam = Beam(self.beam_size, self.sos_id, self.eos_id)
                input_ids = beam.getCurrentState()
                context = context.repeat(1, self.beam_size, 1)
                context_mask = context_mask.repeat(self.beam_size, 1)
                for _ in range(self.max_length):
                    if beam.done():
                        break
                    attn_mask = -1e4 * (1 - self.bias[:input_ids.shape[1], :input_ids.shape[1]])
                    tgt_embeddings = self.encoder.embeddings(input_ids).permute([1, 0, 2]).contiguous()
                    out = self.decoder(tgt_embeddings, context, tgt_mask=attn_mask,
                                       memory_key_padding_mask=~context_mask)
                    # memory_key_padding_mask=(1 - context_mask).bool())
                    out = torch.tanh(self.dense(out))
                    hidden_states = out.permute([1, 0, 2]).contiguous()[:, -1, :]
                    out = self.lsm(self.lm_head(hidden_states)).data
                    beam.advance(out)
                    input_ids.data.copy_(input_ids.data.index_select(0, beam.getCurrentOrigin()))
                    input_ids = torch.cat((input_ids, beam.getCurrentState()), -1)
                hyp = beam.getHyp(beam.getFinal())
                pred = beam.buildTargetTokens(hyp)[:self.beam_size]
                pred = [torch.cat([x.view(-1) for x in p] + [zero] * (self.max_length - len(p))).view(1, -1) for p in
                        pred]
                preds.append(torch.cat(pred, 0).unsqueeze(0))

            preds = torch.cat(preds, 0)
            return preds


class Beam(object):
    def __init__(self, size, sos, eos):
        self.size = size
        self.tt = torch.cuda
        # The score for each translation on the beam.
        self.scores = self.tt.FloatTensor(size).zero_()
        # The backpointers at each time-step.
        self.prevKs = []
        # The outputs at each time-step.
        self.nextYs = [self.tt.LongTensor(size)
                           .fill_(0)]
        self.nextYs[0][0] = sos
        # Has EOS topped the beam yet.
        self._eos = eos
        self.eosTop = False
        # Time and k pair for finished.
        self.finished = []

    def getCurrentState(self):
        "Get the outputs for the current timestep."
        batch = self.tt.LongTensor(self.nextYs[-1]).view(-1, 1)
        return batch

    def getCurrentOrigin(self):
        "Get the backpointers for the current timestep."
        return self.prevKs[-1]

    def advance(self, wordLk):
        """
        Given prob over words for every last beam `wordLk` and attention
        `attnOut`: Compute and update the beam search.

        Parameters:

        * `wordLk`- probs of advancing from the last step (K x words)
        * `attnOut`- attention at the last step

        Returns: True if beam search is complete.
        """
        numWords = wordLk.size(1)

        # Sum the previous scores.
        if len(self.prevKs) > 0:
            beamLk = wordLk + self.scores.unsqueeze(1).expand_as(wordLk)

            # Don't let EOS have children.
            for i in range(self.nextYs[-1].size(0)):
                if self.nextYs[-1][i] == self._eos:
                    beamLk[i] = -1e20
        else:
            beamLk = wordLk[0]
        flatBeamLk = beamLk.view(-1)
        bestScores, bestScoresId = flatBeamLk.topk(self.size, 0, True, True)

        self.scores = bestScores

        # bestScoresId is flattened beam x word array, so calculate which
        # word and beam each score came from
        prevK = bestScoresId // numWords
        self.prevKs.append(prevK)
        self.nextYs.append((bestScoresId - prevK * numWords))

        for i in range(self.nextYs[-1].size(0)):
            if self.nextYs[-1][i] == self._eos:
                s = self.scores[i]
                self.finished.append((s, len(self.nextYs) - 1, i))

        # End condition is when top-of-beam is EOS and no global score.
        if self.nextYs[-1][0] == self._eos:
            self.eosTop = True

    def done(self):
        return self.eosTop and len(self.finished) >= self.size

    def getFinal(self):
        if len(self.finished) == 0:
            self.finished.append((self.scores[0], len(self.nextYs) - 1, 0))
        self.finished.sort(key=lambda a: -a[0])
        if len(self.finished) != self.size:
            unfinished = []
            for i in range(self.nextYs[-1].size(0)):
                if self.nextYs[-1][i] != self._eos:
                    s = self.scores[i]
                    unfinished.append((s, len(self.nextYs) - 1, i))
            unfinished.sort(key=lambda a: -a[0])
            self.finished += unfinished[:self.size - len(self.finished)]
        return self.finished[:self.size]

    def getHyp(self, beam_res):
        """
        Walk back to construct the full hypothesis.
        """
        hyps = []
        for _, timestep, k in beam_res:
            hyp = []
            for j in range(len(self.prevKs[:timestep]) - 1, -1, -1):
                hyp.append(self.nextYs[j + 1][k])
                k = self.prevKs[j][k]
            hyps.append(hyp[::-1])
        return hyps

    def buildTargetTokens(self, preds):
        sentence = []
        for pred in preds:
            tokens = []
            for tok in pred:
                if tok == self._eos:
                    break
                tokens.append(tok)
            sentence.append(tokens)
        return sentence
