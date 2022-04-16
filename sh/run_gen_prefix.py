# coding=utf-8
# Copyright 2018 The Google AI Language Team Authors and The HuggingFace Inc. team.
# Copyright (c) 2018, NVIDIA CORPORATION.  All rights reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
"""
Fine-tuning the library models for language modeling on a text file (GPT, GPT-2, BERT, RoBERTa).
GPT and GPT-2 are fine-tuned using a causal language modeling (CLM) loss while BERT and RoBERTa are fine-tuned
using a masked language modeling (MLM) loss.
"""
import os
import sys

sys.path.append('..')
# os.environ['CUDA_VISIBLE_DEVICES'] = "0"

import models

import torch
import logging
import argparse
import math
import numpy as np
from tqdm import tqdm
import multiprocessing
import time
import sys
import pdb

from torch.utils.tensorboard import SummaryWriter
from torch.utils.data import DataLoader, SequentialSampler, RandomSampler
from torch.utils.data.distributed import DistributedSampler
from transformers import AdamW, get_linear_schedule_with_warmup
from models import build_or_load_gen_model, freeze_codet5, add_soft_prompt, Codet5_prefix, Codet5_decoder_prefix, \
    Codet5_encoder_decoder_prefix
from evaluator import smooth_bleu
from evaluator.CodeBLEU import calc_code_bleu
from evaluator.bleu import _bleu
from utils import get_filenames, get_elapse_time, load_and_cache_gen_data
from configs import add_args, set_seed, set_dist

logging.basicConfig(format='%(asctime)s - %(levelname)s - %(name)s -   %(message)s',
                    datefmt='%m/%d/%Y %H:%M:%S',
                    level=logging.INFO)
logger = logging.getLogger(__name__)

"""
copied from transcoder, note that transcoder's data shape is (slen,n), but our codeT5's data shape is (n, slen)
we keep the code unchanged, and first transpose our data.
"""


def word_shuffle(x, l):
    """
    Randomly shuffle input words.
    """
    # if self.params.word_shuffle == 0:
    #     return x, l

    # transcoder uses 3 for the optimal of noise scores
    word_shuffle_param = 3
    # define noise word scores
    noise = np.random.uniform(
        0, word_shuffle_param, size=(x.size(0) - 1, x.size(1)))
    noise[0] = -1  # do not move start sentence symbol

    assert word_shuffle_param > 1
    x2 = x.clone()
    for i in range(l.size(0)):
        # generate a random permutation
        scores = np.arange(l[i] - 1) + noise[:l[i] - 1, i]
        permutation = scores.argsort()
        # shuffle words
        x2[:l[i] - 1, i].copy_(x2[:l[i] - 1, i]
                               [torch.from_numpy(permutation)])
    return x2, l


def word_dropout(tokenizer, x, l):
    """
    Randomly drop input words.
    """
    # if self.params.word_dropout == 0:
    #     return x, l
    word_dropout_param = 0.1
    assert 0 < word_dropout_param < 1

    # define words to drop
    eos = tokenizer.eos_token_id
    bos = tokenizer.bos_token_id
    assert (x[0] == bos).sum() == l.size(0)
    keep = np.random.rand(x.size(0) - 1, x.size(1)
                          ) >= word_dropout_param
    keep[0] = 1  # do not drop the start sentence symbol

    sentences = []
    lengths = []
    for i in range(l.size(0)):
        assert x[l[i] - 1, i] == eos
        words = x[:l[i] - 1, i].tolist()
        # randomly drop words from the input
        new_s = [w for j, w in enumerate(words) if keep[j, i]]
        # we need to have at least one word in the sentence (more than the start / end sentence symbols)
        if len(new_s) == 1:
            new_s.append(words[np.random.randint(1, len(words))])
        new_s.append(eos)
        assert len(new_s) >= 3 and new_s[0] == bos and new_s[-1] == eos
        sentences.append(new_s)
        lengths.append(len(new_s))
    # re-construct input
    l2 = torch.LongTensor(lengths)
    x2 = torch.LongTensor(l2.max(), l2.size(
        0)).fill_(tokenizer.pad_token_id)
    for i in range(l2.size(0)):
        x2[:l2[i], i].copy_(torch.LongTensor(sentences[i]))
    return x2, l2


def word_blank(max_length, tokenizer, x, l):
    """
    Randomly blank input words.
    """
    word_blank_param = 0.1
    # if self.params.word_blank == 0:
    #     return x, l
    # assert 0 < self.params.word_blank < 1

    # define words to blank
    bos = tokenizer.bos_token_id
    eos = tokenizer.eos_token_id
    assert (x[0] == bos).sum() == l.size(0)
    keep = np.random.rand(x.size(0) - 1, x.size(1)
                          ) >= word_blank_param
    keep[0] = 1  # do not blank the start sentence symbol

    sentences = []
    for i in range(l.size(0)):
        assert x[l[i] - 1, i] == eos
        words = x[:l[i] - 1, i].tolist()
        # randomly blank words from the input
        new_s = [w if keep[j, i]
                 else tokenizer.mask_token_id for j, w in enumerate(words)]
        new_s.append(eos)
        assert len(new_s) == l[i] and new_s[0] == bos and new_s[-1] == eos
        sentences.append(new_s)
    # re-construct input
    x2 = torch.LongTensor(max_length, l.size(0)).fill_(tokenizer.pad_token_id)
    for i in range(l.size(0)):
        x2[:l[i], i].copy_(torch.LongTensor(sentences[i]))
    return x2, l


def add_noise(max_length, tokenizer, words, lengths):
    """
    Add noise to the encoder input.
    """
    words, lengths = word_shuffle(words, lengths)
    words, lengths = word_dropout(tokenizer, words, lengths)
    words, lengths = word_blank(max_length, tokenizer, words, lengths)
    return words, lengths


""""""


def print_params(model):
    Total_params = 0
    Trainable_params = 0
    NonTrainable_params = 0

    # 遍历model.parameters()返回的全局参数列表
    for param in model.parameters():
        mulValue = np.prod(param.size())  # 使用numpy prod接口计算参数数组所有元素之积
        Total_params += mulValue  # 总参数量
        if param.requires_grad:
            Trainable_params += mulValue  # 可训练参数量
        else:
            NonTrainable_params += mulValue  # 非可训练参数量

    print(f'Total params: {Total_params}')
    print(f'Trainable params: {Trainable_params}')
    print(f'Non-trainable params: {NonTrainable_params}')


def eval_ppl_epoch(args, eval_data, eval_examples, model, tokenizer):
    eval_sampler = SequentialSampler(eval_data)
    eval_dataloader = DataLoader(eval_data, sampler=eval_sampler, batch_size=args.eval_batch_size,
                                 num_workers=4, pin_memory=True)
    # Start evaluating model
    logger.info("  " + "***** Running ppl evaluation *****")
    logger.info("  Num examples = %d", len(eval_examples))
    logger.info("  Batch size = %d", args.eval_batch_size)

    model.eval()
    eval_loss, batch_num = 0, 0
    for batch in tqdm(eval_dataloader, total=len(eval_dataloader), desc="Eval ppl"):
        batch = tuple(t.to(args.device) for t in batch)
        source_ids, target_ids = batch

        source_mask = source_ids.ne(tokenizer.pad_token_id)
        target_mask = target_ids.ne(tokenizer.pad_token_id)

        with torch.no_grad():
            if args.model_type == 'roberta':
                loss, _, _ = model(source_ids=source_ids, source_mask=source_mask,
                                   target_ids=target_ids, target_mask=target_mask)
            else:
                outputs = model(input_ids=source_ids, attention_mask=source_mask,
                                labels=target_ids, decoder_attention_mask=target_mask)
                loss = outputs.loss

        eval_loss += loss.item()
        batch_num += 1
    eval_loss = eval_loss / batch_num
    eval_ppl = round(np.exp(eval_loss), 5)
    return eval_ppl


def eval_bleu_epoch(args, eval_data, eval_examples, model, tokenizer, split_tag, criteria):
    logger.info("  ***** Running bleu evaluation on {} data*****".format(split_tag))
    logger.info("  Num examples = %d", len(eval_examples))
    logger.info("  Batch size = %d", args.eval_batch_size)
    eval_sampler = SequentialSampler(eval_data)
    if args.data_num == -1:
        eval_dataloader = DataLoader(eval_data, sampler=eval_sampler, batch_size=args.eval_batch_size,
                                     num_workers=4, pin_memory=True)
    else:
        eval_dataloader = DataLoader(eval_data, sampler=eval_sampler, batch_size=args.eval_batch_size)

    model.eval()
    pred_ids = []
    bleu, codebleu = 0.0, 0.0
    for batch in tqdm(eval_dataloader, total=len(eval_dataloader), desc="Eval bleu for {} set".format(split_tag)):
        source_ids = batch[0].to(args.device)
        source_mask = source_ids.ne(tokenizer.pad_token_id)
        with torch.no_grad():
            if args.model_type == 'roberta':
                preds = model(source_ids=source_ids, source_mask=source_mask)

                top_preds = [pred[0].cpu().numpy() for pred in preds]
            else:
                preds = model.generate(source_ids,
                                       attention_mask=source_mask,
                                       use_cache=True,
                                       num_beams=args.beam_size,
                                       early_stopping=args.task == 'summarize',
                                       max_length=args.max_target_length)
                top_preds = list(preds.cpu().numpy())
            pred_ids.extend(top_preds)
    # pdb.set_trace()
    pred_nls = [tokenizer.decode(id, skip_special_tokens=True, clean_up_tokenization_spaces=False) for id in pred_ids]

    output_fn = os.path.join(args.res_dir, "test_{}.output".format(criteria))
    gold_fn = os.path.join(args.res_dir, "test_{}.gold".format(criteria))
    src_fn = os.path.join(args.res_dir, "test_{}.src".format(criteria))

    if args.task in ['defect']:
        target_dict = {0: 'false', 1: 'true'}
        golds = [target_dict[ex.target] for ex in eval_examples]
        eval_acc = np.mean([int(p == g) for p, g in zip(pred_nls, golds)])
        result = {'em': eval_acc, 'bleu': 0, 'codebleu': 0}

        with open(output_fn, 'w') as f, open(gold_fn, 'w') as f1, open(src_fn, 'w') as f2:
            for pred_nl, gold in zip(pred_nls, eval_examples):
                f.write(pred_nl.strip() + '\n')
                f1.write(target_dict[gold.target] + '\n')
                f2.write(gold.source.strip() + '\n')
            logger.info("Save the predictions into %s", output_fn)
    else:
        dev_accs, predictions = [], []
        with open(output_fn, 'w') as f, open(gold_fn, 'w') as f1, open(src_fn, 'w') as f2:
            for pred_nl, gold in zip(pred_nls, eval_examples):
                dev_accs.append(pred_nl.strip() == gold.target.strip())
                if args.task in ['summarize']:
                    predictions.append(str(gold.idx) + '\t' + pred_nl)
                    f.write(str(gold.idx) + '\t' + pred_nl.strip() + '\n')
                    f1.write(str(gold.idx) + '\t' + gold.target.strip() + '\n')
                    f2.write(str(gold.idx) + '\t' + gold.source.strip() + '\n')
                else:
                    f.write(pred_nl.strip() + '\n')
                    f1.write(gold.target.strip() + '\n')
                    f2.write(gold.source.strip() + '\n')

        if args.task in ['summarize']:
            (goldMap, predictionMap) = smooth_bleu.computeMaps(predictions, gold_fn)
            bleu = round(smooth_bleu.bleuFromMaps(goldMap, predictionMap)[0], 2)
        else:
            bleu = round(_bleu(gold_fn, output_fn), 2)
            if split_tag == 'test' and args.task in ['refine', 'translate', 'concode']:
                codebleu = calc_code_bleu.get_codebleu(gold_fn, output_fn, args.lang)
        # except:
        #     bleu = 0.0
        #     codebleu = 0.0

        em = np.mean(dev_accs) * 100
        result = {'em': em, 'bleu': bleu}
        if not args.task == 'summarize' and split_tag == 'test':
            result['codebleu'] = codebleu * 100

    logger.info("***** Eval results *****")
    for key in sorted(result.keys()):
        logger.info("  %s = %s", key, str(round(result[key], 4)))

    return result


def main():
    parser = argparse.ArgumentParser()
    args = add_args(parser)
    logger.info(args)
    # os.environ['CUDA_VISIBLE_DEVICES'] = args.gpu
    # Todo : model  parallel
    os.environ['CUDA_VISIBLE_DEVICES'] = args.gpu
    t0 = time.time()
    # 1 for PPT,3 for PPT with LMadption
    if (args.LMadaption == 4) and args.task == "translate":
        args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption4_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"

    if (args.LMadaption == 2) and args.task == "translate" and (
            args.sub_task == 'java-cs' or args.sub_task == 'cs-java' or args.sub_task == 'java-cpp'):
        args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption_onlyLMadaption_prefixlen0_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
    if (args.LMadaption == 2) and args.task == "translate" and (
            args.sub_task == 'java-python' or args.sub_task == 'python-java'):
        args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e2_gradientAccumulationSteps1_LMadaption2ForTranscoder_java-python_prefixlen0_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
    if (args.LMadaption == 2) and args.task == "translate" and (
            args.sub_task == 'java-go' or args.sub_task == 'go-java'):
        args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-go/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption2ForLeetcode_java-go_prefixlen0_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
    if (args.LMadaption == 2) and args.task == "translate" and (
            args.sub_task == 'python-go' or args.sub_task == 'go-python'):
        args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/python-go/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption2ForLeetcode_python-go_prefixlen0_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"

    if (args.LMadaption == 1) and args.task == "translate":
        if args.prompt_len == 150 and (
                args.sub_task == 'java-cs' or args.sub_task == 'cs-java' or args.sub_task == 'java-cpp'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption_Prefix_prefixlen150_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (
                args.sub_task == 'java-cs' or args.sub_task == 'cs-java' or args.sub_task == 'java-cpp'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption_prefix_middim_100_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (args.sub_task == 'java-python' or args.sub_task == 'python-java'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e2_gradientAccumulationSteps1_LMadaption1ForTranscoder_java-python_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (args.sub_task == 'java-go' or args.sub_task == 'go-java'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-go/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption1ForLeetcode_java-go_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (args.sub_task == 'python-go' or args.sub_task == 'go-python'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/python-go/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption1ForLeetcode_python-go_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"

    if (args.LMadaption == 3) and args.task == "translate":
        if args.prompt_len == 100 and (args.sub_task == 'java-python' or args.sub_task == 'python-java'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e2_gradientAccumulationSteps1_LMadaption3ForTranscoder_java-python_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (
                args.sub_task == 'java-cs' or args.sub_task == 'cs-java' or args.sub_task == 'java-cpp'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption_prefixwithLM_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 150 and (args.sub_task == 'java-cs' or args.sub_task == 'cs-java'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption_LMWithPrefix_prefixlen150_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (args.sub_task == 'java-go' or args.sub_task == 'go-java'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/java-go/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption3ForLeetcode_java-go_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
        if args.prompt_len == 100 and (args.sub_task == 'python-go' or args.sub_task == 'go-python'):
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/translate/python-go/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption3ForLeetcode_python-go_prefixlen100_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"

    if (args.LMadaption == 1) and args.task == "summarize":
        if args.prompt_len == 100:
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/summarize/java/codet5_base_all_lr10_bs20_src256_trg128_pat2_e15_gradientAccumulationSteps2_EnDePrefix_prefixlen100_prefixmiddim512_promptType3/checkpoint-best-bleu/pytorch_model.bin"
        if args.prompt_len == 150:
            args.load_model_path = "/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/summarize/java/codet5_base_all_lr10_bs16_src256_trg128_pat2_e10_gradientAccumulationSteps1_LMadaption_prefix_prefixlen150_prefixmiddim512_promptType3/checkpoint-last/pytorch_model.bin"
    set_dist(args)
    set_seed(args)
    config, model, tokenizer = build_or_load_gen_model(args)
    assert args.model_type == "codet5", "Only support codet5 prefix at present"

    model.to(args.device)

    if args.n_gpu > 1:
        # for DataParallel
        model = torch.nn.DataParallel(model)

    # 2 for only LMadaption
    if args.load_model_path is not None and (args.LMadaption == 2):
        print("reload LMadaption model")
        logger.info("Reload model from {}".format(args.load_model_path))
        model.load_state_dict(torch.load(args.load_model_path))
        print("loaded LMadapted model params:")
        print_params(model)

    if args.prompt_len > 0:
        if args.freeze == 1:
            freeze_codet5(model)
        if args.prompt_type == 1:
            model = Codet5_prefix(model, args.prompt_len, config, model.get_input_embeddings(), args.prefix_middim)
        if args.prompt_type == 2:
            model = Codet5_decoder_prefix(model, args.prompt_len, config, model.get_input_embeddings(),
                                          args.prefix_middim)
        if args.prompt_type == 3:
            model = Codet5_encoder_decoder_prefix(model, args.prompt_len, config, model.get_input_embeddings(),
                                                  args.prefix_middim)
    # print model structure
    # print(model)
    # 1 for PPT, 3 forPPT with LMadaption, 4 for first LMadaption then PPT
    if args.load_model_path is not None and (args.LMadaption == 1 or args.LMadaption == 3 or args.LMadaption == 4):
        print("reload model")
        logger.info("Reload model from {}".format(args.load_model_path))
        model.load_state_dict(torch.load(args.load_model_path))
        print("loaded  PPT model params:")
        if (args.LMadaption == 3):
            print("PPT with LMadaption..")
        if (args.LMadaption == 4):
            print("first LMadaption, then PPT..")
        print("reloaded params: ")
        print_params(model)

    # for test, reload model and do test
    if args.load_model_path is not None and (args.LMadaption == 0):
        print("reload LMadaption=0 model")
        logger.info("Reload model from {}".format(args.load_model_path))
        model.load_state_dict(torch.load(args.load_model_path))
        print("loaded LMadapted model params:")
        print_params(model)

    # if DAE or BT
    if args.DAE==1:
        print(" doing  DAE, add noise to source ids.... ")
        # DAE use base codeT5 model
        # So do not need to reload
        # print("reload model")
        # logger.info("Reload model from {}".format(DAE_model_path))
        # model.load_state_dict(torch.load(DAE_model_path))
        # print("loaded DAE model params:")
        # print_params(model)

    pool = multiprocessing.Pool(args.cpu_cont)
    args.train_filename, args.dev_filename, args.test_filename = get_filenames(args.data_dir, args.task, args.sub_task)
    fa = open(os.path.join(args.output_dir, 'summary.log'), 'a+')

    if args.BT == 1:
        config2, model2, tokenizer2 = build_or_load_gen_model(args)
        model2.to(args.device)
        model1 = model
        logger.info("Reload bt model1 from {}".format(args.BT_model1_path))
        model1.load_state_dict(torch.load(args.BT_model1_path))
        logger.info("Reload bt model2 from {}".format(args.BT_model2_path))
        model2.load_state_dict(torch.load(args.BT_model2_path))

        # Prepare training data loader
        print("load BT data...")

        train_examples, train_data = load_and_cache_gen_data(args, args.train_filename, pool, tokenizer, 'train')
        train_sampler = RandomSampler(train_data) if args.local_rank == -1 else DistributedSampler(train_data)
        train_dataloader = DataLoader(train_data, sampler=train_sampler, batch_size=args.train_batch_size,
                                      num_workers=4, pin_memory=True)

        # Prepare optimizer and schedule (linear warmup and decay)
        no_decay = ['bias', 'LayerNorm.weight']
        optimizer_grouped_parameters_model1 = [
            {'params': [p for n, p in model1.named_parameters() if not any(nd in n for nd in no_decay)],
             'weight_decay': args.weight_decay},
            {'params': [p for n, p in model1.named_parameters() if any(nd in n for nd in no_decay)],
             'weight_decay': 0.0}
        ]
        optimizer_grouped_parameters_model2 = [
            {'params': [p for n, p in model2.named_parameters() if not any(nd in n for nd in no_decay)],
             'weight_decay': args.weight_decay},
            {'params': [p for n, p in model2.named_parameters() if any(nd in n for nd in no_decay)],
             'weight_decay': 0.0}
        ]
        optimizer1 = AdamW(optimizer_grouped_parameters_model1, lr=args.learning_rate, eps=args.adam_epsilon)
        optimizer2 = AdamW(optimizer_grouped_parameters_model2, lr=args.learning_rate, eps=args.adam_epsilon)

        num_train_optimization_steps = args.num_train_epochs * len(train_dataloader)
        scheduler1 = get_linear_schedule_with_warmup(optimizer1,
                                                     num_warmup_steps=args.warmup_steps,
                                                     num_training_steps=num_train_optimization_steps)
        scheduler2 = get_linear_schedule_with_warmup(optimizer2,
                                                     num_warmup_steps=args.warmup_steps,
                                                     num_training_steps=num_train_optimization_steps)

        # Start training
        train_example_num = len(train_data)
        logger.info("***** Running training *****")
        logger.info("  Num examples = %d", train_example_num)
        logger.info("  Batch size = %d", args.train_batch_size)
        logger.info("  Batch num = %d", math.ceil(train_example_num / args.train_batch_size))
        logger.info("  Num epoch = %d", args.num_train_epochs)

        dev_dataset = {}
        global_step, best_bleu_em, best_ppl = 0, -1, 1e6
        not_loss_dec_cnt, not_bleu_em_inc_cnt = 0, 0 if args.do_eval_bleu else 1e6
        # print_params(model)
        for cur_epoch in range(args.start_epoch, int(args.num_train_epochs)):
            bar = tqdm(train_dataloader, total=len(train_dataloader), desc="Training")
            nb_tr_examples, nb_tr_steps, tr_loss1,tr_loss2 = 0, 0, 0,0


            for step, batch in enumerate(bar):
                # src_ids for java, tgt_ids for go,
                # for java, use model2 to generate middle go translation, and train model1 use mid translation as source
                # use original java as target.
                # for go, verse versa
                batch = tuple(t.to(args.device) for t in batch)
                source_ids, target_ids = batch
                source_mask = source_ids.ne(tokenizer.pad_token_id)
                target_mask = target_ids.ne(tokenizer.pad_token_id)

                # for language 1 (java ), generate middle translation for BT.
                with torch.no_grad():
                    model2.eval()

                    preds = model2.generate(source_ids,
                                            attention_mask=source_mask,
                                            use_cache=True,
                                            max_length=args.max_target_length)
                    top_preds = list(preds.cpu().numpy())
                pred_nls = [tokenizer.decode(id, skip_special_tokens=True, clean_up_tokenization_spaces=False) for
                                id in top_preds]

                for i in range(len(pred_nls)):
                    pred_nls[i] = pred_nls[i].replace('</s>', '<unk>')
                    pred_nls[i] = tokenizer.encode(pred_nls[i], max_length=args.max_source_length, padding='max_length',
                                     truncation=True)

                mid_source_ids = torch.tensor(pred_nls, dtype=torch.long).to(args.device)
                mid_source_mask = mid_source_ids.ne(tokenizer.pad_token_id)
                model1.train()
                #use mid_source_ids as source, use original source_ids as target, then train
                outputs1 = model1(input_ids=mid_source_ids, attention_mask=mid_source_mask,
                                labels=source_ids, decoder_attention_mask=source_mask)
                loss1 = outputs1.loss

                if args.n_gpu > 1:
                    loss1 = loss1.mean()  # mean() to average on multi-gpu.
                if args.gradient_accumulation_steps > 1:
                    loss1 = loss1 / args.gradient_accumulation_steps
                tr_loss1 += loss1.item()

                # nb_tr_examples += source_ids.size(0)

                loss1.backward()

                # Update parameters
                optimizer1.step()
                optimizer1.zero_grad()
                scheduler1.step()


                # for language 2 (go)

                with torch.no_grad():
                    model1.eval()

                    preds = model1.generate(target_ids,
                                            attention_mask=target_mask,
                                            use_cache=True,
                                            max_length=args.max_target_length)
                    top_preds = list(preds.cpu().numpy())

                pred_nls = [tokenizer.decode(id, skip_special_tokens=True, clean_up_tokenization_spaces=False) for
                            id in top_preds]

                for i in range(len(pred_nls)):
                    pred_nls[i] = pred_nls[i].replace('</s>', '<unk>')
                    pred_nls[i] = tokenizer.encode(pred_nls[i], max_length=args.max_source_length, padding='max_length',
                                                   truncation=True)


                mid_source_ids = torch.tensor(pred_nls, dtype=torch.long).to(args.device)
                mid_source_mask = mid_source_ids.ne(tokenizer.pad_token_id)
                # use mid_source_ids as source, use original source_ids as target, then train
                model2.train()
                outputs2 = model2(input_ids=mid_source_ids, attention_mask=mid_source_mask,
                                  labels=target_ids, decoder_attention_mask=target_mask)
                loss2 = outputs2.loss

                if args.n_gpu > 1:
                    loss2 = loss2.mean()  # mean() to average on multi-gpu.
                if args.gradient_accumulation_steps > 1:
                    loss2 = loss2 / args.gradient_accumulation_steps
                tr_loss2 += loss2.item()

                # nb_tr_examples += source_ids.size(0)

                loss2.backward()

                # Update parameters
                optimizer2.step()
                optimizer2.zero_grad()
                scheduler2.step()

                nb_tr_steps += 1
                global_step += 1
                train_loss1 = round(tr_loss1 * args.gradient_accumulation_steps / (nb_tr_steps + 1), 4)
                train_loss2 = round(tr_loss2 * args.gradient_accumulation_steps / (nb_tr_steps + 1), 4)
                bar.set_description("[{}] Train loss1 {}, loss2 {}".format(cur_epoch, round(train_loss1, 3),round(train_loss2,3)))



            output_dir1=args.output_dir
            output_dir2=args.BT_model2_outputpath
            last_output_dir1 = os.path.join(output_dir1, 'checkpoint-last')
            last_output_dir2 = os.path.join(output_dir2, 'checkpoint-last')
            if not os.path.exists(last_output_dir1):
                os.makedirs(last_output_dir1)
            if not os.path.exists(last_output_dir2):
                os.makedirs(last_output_dir2)
            model1_to_save = model1.module if hasattr(model1, 'module') else model1
            model2_to_save = model2.module if hasattr(model2, 'module') else model2
            output_model1_file = os.path.join(last_output_dir1, "pytorch_model.bin")
            output_model2_file = os.path.join(last_output_dir2, "pytorch_model.bin")
            torch.save(model1_to_save.state_dict(), output_model1_file)
            torch.save(model2_to_save.state_dict(), output_model2_file)
            logger.info("Save the last model1 into %s, model2 into %s", output_model1_file,output_model2_file)
    else:

        if  args.do_train:
            if args.local_rank in [-1, 0] and args.data_num == -1:
                summary_fn = './tensorboard/{}'.format('/'.join(args.output_dir.split('/')[1:]))
                tb_writer = SummaryWriter(summary_fn)

            # Prepare training data loader
            print("load data...")
            train_examples, train_data = load_and_cache_gen_data(args, args.train_filename, pool, tokenizer, 'train')
            train_sampler = RandomSampler(train_data) if args.local_rank == -1 else DistributedSampler(train_data)
            train_dataloader = DataLoader(train_data, sampler=train_sampler, batch_size=args.train_batch_size,
                                          num_workers=4, pin_memory=True)

            # Prepare optimizer and schedule (linear warmup and decay)
            no_decay = ['bias', 'LayerNorm.weight']
            optimizer_grouped_parameters = [
                {'params': [p for n, p in model.named_parameters() if not any(nd in n for nd in no_decay)],
                 'weight_decay': args.weight_decay},
                {'params': [p for n, p in model.named_parameters() if any(nd in n for nd in no_decay)], 'weight_decay': 0.0}
            ]
            optimizer = AdamW(optimizer_grouped_parameters, lr=args.learning_rate, eps=args.adam_epsilon)
            num_train_optimization_steps = args.num_train_epochs * len(train_dataloader)
            scheduler = get_linear_schedule_with_warmup(optimizer,
                                                        num_warmup_steps=args.warmup_steps,
                                                        num_training_steps=num_train_optimization_steps)

            # Start training
            train_example_num = len(train_data)
            logger.info("***** Running training *****")
            logger.info("  Num examples = %d", train_example_num)
            logger.info("  Batch size = %d", args.train_batch_size)
            logger.info("  Batch num = %d", math.ceil(train_example_num / args.train_batch_size))
            logger.info("  Num epoch = %d", args.num_train_epochs)

            dev_dataset = {}
            global_step, best_bleu_em, best_ppl = 0, -1, 1e6
            not_loss_dec_cnt, not_bleu_em_inc_cnt = 0, 0 if args.do_eval_bleu else 1e6
            print_params(model)
            for cur_epoch in range(args.start_epoch, int(args.num_train_epochs)):
                bar = tqdm(train_dataloader, total=len(train_dataloader), desc="Training")
                nb_tr_examples, nb_tr_steps, tr_loss = 0, 0, 0

                model.train()

                # if(cur_epoch==2):
                #     if args.prompt_len>0:
                #         logger.info("start tuning softprompt...")
                #
                #         freeze_codet5(model)
                #         add_soft_prompt(model,args.prompt_len)
                #         print_params(model)

                for step, batch in enumerate(bar):
                    batch = tuple(t.to(args.device) for t in batch)
                    source_ids, target_ids = batch
                    source_mask = source_ids.ne(tokenizer.pad_token_id)
                    target_mask = target_ids.ne(tokenizer.pad_token_id)

                    if args.DAE==1:
                        # print(" doing  DAE, add noise to source ids.... ")
                        source_ids = torch.transpose(source_ids, 0, 1).cpu()
                        source_lengths = (source_ids.ne(tokenizer.pad_token_id) == True).sum(dim=0).cpu()
                        source_ids, _ = add_noise(args.max_source_length, tokenizer, source_ids, source_lengths)
                        source_ids = torch.transpose(source_ids, 0, 1).to(args.device)
                        source_mask = source_ids.ne(tokenizer.pad_token_id)

                    if args.model_type == 'roberta':
                        loss, _, _ = model(source_ids=source_ids, source_mask=source_mask,
                                           target_ids=target_ids, target_mask=target_mask)
                    else:
                        outputs = model(input_ids=source_ids, attention_mask=source_mask,
                                        labels=target_ids, decoder_attention_mask=target_mask)
                        loss = outputs.loss

                    if args.n_gpu > 1:
                        loss = loss.mean()  # mean() to average on multi-gpu.
                    if args.gradient_accumulation_steps > 1:
                        loss = loss / args.gradient_accumulation_steps
                    tr_loss += loss.item()

                    nb_tr_examples += source_ids.size(0)
                    nb_tr_steps += 1
                    loss.backward()

                    if nb_tr_steps % args.gradient_accumulation_steps == 0:
                        # Update parameters
                        optimizer.step()
                        optimizer.zero_grad()
                        scheduler.step()
                        global_step += 1
                        train_loss = round(tr_loss * args.gradient_accumulation_steps / (nb_tr_steps + 1), 4)
                        bar.set_description("[{}] Train loss {}".format(cur_epoch, round(train_loss, 3)))


                if args.save_last_checkpoints:
                    last_output_dir = os.path.join(args.output_dir, 'checkpoint-last')
                    if not os.path.exists(last_output_dir):
                        os.makedirs(last_output_dir)
                    model_to_save = model.module if hasattr(model, 'module') else model
                    output_model_file = os.path.join(last_output_dir, "pytorch_model.bin")
                    torch.save(model_to_save.state_dict(), output_model_file)
                    logger.info("Save the last model into %s", output_model_file)

                if args.do_eval:
                    # Eval model with dev dataset
                    if 'dev_loss' in dev_dataset:
                        eval_examples, eval_data = dev_dataset['dev_loss']
                    else:
                        eval_examples, eval_data = load_and_cache_gen_data(args, args.dev_filename, pool, tokenizer, 'dev')
                        dev_dataset['dev_loss'] = eval_examples, eval_data

                    eval_ppl = eval_ppl_epoch(args, eval_data, eval_examples, model, tokenizer)
                    result = {'epoch': cur_epoch, 'global_step': global_step, 'eval_ppl': eval_ppl}
                    for key in sorted(result.keys()):
                        logger.info("  %s = %s", key, str(result[key]))
                    logger.info("  " + "*" * 20)
                    if args.data_num == -1:
                        tb_writer.add_scalar('dev_ppl', eval_ppl, cur_epoch)

                    # save last checkpoint
                    # if args.save_last_checkpoints:
                    #     last_output_dir = os.path.join(args.output_dir, 'checkpoint-last')
                    #     if not os.path.exists(last_output_dir):
                    #         os.makedirs(last_output_dir)
                    #     model_to_save = model.module if hasattr(model, 'module') else model
                    #      output_model_file = os.path.join(last_output_dir, "pytorch_model.bin")
                    #      torch.save(model_to_save.state_dict(), output_model_file)
                    #      logger.info("Save the last model into %s", output_model_file)

                    if eval_ppl < best_ppl:
                        not_loss_dec_cnt = 0
                        logger.info("  Best ppl:%s", eval_ppl)
                        logger.info("  " + "*" * 20)
                        fa.write("[%d] Best ppl changed into %.4f\n" % (cur_epoch, eval_ppl))
                        best_ppl = eval_ppl

                        # Save best checkpoint for best ppl
                        output_dir = os.path.join(args.output_dir, 'checkpoint-best-ppl')
                        if not os.path.exists(output_dir):
                            os.makedirs(output_dir)
                        if args.always_save_model:
                            model_to_save = model.module if hasattr(model, 'module') else model
                            output_model_file = os.path.join(output_dir, "pytorch_model.bin")
                            torch.save(model_to_save.state_dict(), output_model_file)
                            logger.info("Save the best ppl model into %s", output_model_file)
                    else:
                        not_loss_dec_cnt += 1
                        logger.info("Ppl does not decrease for %d epochs", not_loss_dec_cnt)
                        if all([x > args.patience for x in [not_bleu_em_inc_cnt, not_loss_dec_cnt]]):
                            early_stop_str = "[%d] Early stop as not_bleu_em_inc_cnt=%d, and not_loss_dec_cnt=%d\n" % (
                                cur_epoch, not_bleu_em_inc_cnt, not_loss_dec_cnt)
                            logger.info(early_stop_str)
                            fa.write(early_stop_str)
                            break
                    logger.info("***** CUDA.empty_cache() *****")
                    torch.cuda.empty_cache()
                    if args.do_eval_bleu:
                        # if(eval_ppl>1.5 and args.task == 'translate'):
                        #     logger.info("no bleu, wait for translation model converge... ")
                        # else:
                        eval_examples, eval_data = load_and_cache_gen_data(args, args.dev_filename, pool, tokenizer, 'dev',
                                                                           only_src=True, is_sample=True)

                        result = eval_bleu_epoch(args, eval_data, eval_examples, model, tokenizer, 'dev', 'e%d' % cur_epoch)
                        dev_bleu, dev_em = result['bleu'], result['em']
                        if args.task in ['summarize']:
                            dev_bleu_em = dev_bleu
                        elif args.task in ['defect']:
                            dev_bleu_em = dev_em
                        else:
                            dev_bleu_em = dev_bleu + dev_em
                        if args.data_num == -1:
                            tb_writer.add_scalar('dev_bleu_em', dev_bleu_em, cur_epoch)
                            # tb_writer.add_scalar('dev_em', dev_em, cur_epoch)
                        if dev_bleu_em > best_bleu_em:
                            not_bleu_em_inc_cnt = 0
                            logger.info("  [%d] Best bleu+em: %.2f (bleu: %.2f, em: %.2f)",
                                        cur_epoch, dev_bleu_em, dev_bleu, dev_em)
                            logger.info("  " + "*" * 20)
                            best_bleu_em = dev_bleu_em
                            fa.write("[%d] Best bleu+em changed into %.2f (bleu: %.2f, em: %.2f)\n" % (
                                cur_epoch, best_bleu_em, dev_bleu, dev_em))
                            # Save best checkpoint for best bleu
                            output_dir = os.path.join(args.output_dir, 'checkpoint-best-bleu')
                            if not os.path.exists(output_dir):
                                os.makedirs(output_dir)
                            if args.data_num == -1 or args.always_save_model:
                                model_to_save = model.module if hasattr(model, 'module') else model
                                output_model_file = os.path.join(output_dir, "pytorch_model.bin")
                                torch.save(model_to_save.state_dict(), output_model_file)
                                logger.info("Save the best bleu model into %s", output_model_file)
                        else:
                            not_bleu_em_inc_cnt += 1
                            logger.info("Bleu does not increase for %d epochs", not_bleu_em_inc_cnt)
                            if all([x > args.patience for x in [not_bleu_em_inc_cnt, not_loss_dec_cnt]]):
                                stop_early_str = "[%d] Early stop as not_bleu_em_inc_cnt=%d, and not_loss_dec_cnt=%d\n" % (
                                    cur_epoch, not_bleu_em_inc_cnt, not_loss_dec_cnt)
                                logger.info(stop_early_str)
                                fa.write(stop_early_str)
                                break
                logger.info("***** CUDA.empty_cache() *****")
                torch.cuda.empty_cache()

            if args.local_rank in [-1, 0] and args.data_num == -1:
                tb_writer.close()
            logger.info("Finish training and take %s", get_elapse_time(t0))

        if args.do_test:
            logger.info("  " + "***** Testing *****")
            logger.info("  Batch size = %d", args.eval_batch_size)
            logger.info("***** CUDA.empty_cache() *****")
            torch.cuda.empty_cache()
            logger.info("target language: " + args.lang)

            for criteria in ['best-bleu', 'best-ppl', 'last']:  # 'best-bleu', 'best-ppl', 'last'

                logger.info("***** CUDA.empty_cache() *****")
                torch.cuda.empty_cache()

                file = os.path.join(args.output_dir, 'checkpoint-{}/pytorch_model.bin'.format(criteria))
                if not (os.path.exists(file)):
                    logger.info(criteria+" checkpoint not found")
                    continue
                logger.info("Reload model from {}".format(file))
                model.load_state_dict(torch.load(file))
                print_params(model)
                eval_examples, eval_data = load_and_cache_gen_data(args, args.test_filename, pool, tokenizer, 'test',
                                                                   only_src=True, is_sample=False)
                result = eval_bleu_epoch(args, eval_data, eval_examples, model, tokenizer, 'test', criteria)
                test_bleu, test_em = result['bleu'], result['em']
                test_codebleu = result['codebleu'] if 'codebleu' in result else 0
                result_str = "[%s] bleu-4: %.2f, em: %.4f, codebleu: %.4f\n" % (criteria, test_bleu, test_em, test_codebleu)
                logger.info(result_str)
                fa.write(result_str)
                if args.res_fn:
                    with open(args.res_fn, 'a+') as f:
                        f.write('[Time: {}] {}\n'.format(get_elapse_time(t0), file))
                        f.write(result_str)
    logger.info("Finish and take {}".format(get_elapse_time(t0)))
    fa.write("Finish and take {}".format(get_elapse_time(t0)))
    fa.close()


if __name__ == "__main__":
    # print(' '.join(sys.argv[:]))
    main()
