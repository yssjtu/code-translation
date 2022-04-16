#!/usr/bin/env python
import os
import argparse


def get_cmd(task, sub_task, model_tag, gpu, data_num, bs, lr, source_length, target_length, patience, epoch, warmup,
            gpu_type,  res_fn,gradient_accumulation_steps,filename_end,prompt_len,prompt_type,prefix_middim,few_shot,freeze,LMadaption,test):
    if prompt_type==0:
        #softprompt
        cmd_str = 'bash exp_with_args_soft_prompt.sh %s %s %s %d %d %d %d %d %d %d %d %d %s %s %d %s %d' % \
                  (task, sub_task, model_tag, gpu, data_num, bs, lr, source_length, target_length, patience, epoch,
                   warmup, gpu_type,  res_fn,gradient_accumulation_steps,filename_end,prompt_len)
    else:
        #prefix
        if(few_shot=='0'):
            cmd_str = 'bash exp_with_args_prefix.sh %s %s %s %d %d %d %d %d %d %d %d %d %s %s %d %s %d %d %d %d %d' % \
                  (task, sub_task, model_tag, gpu, data_num, bs, lr, source_length, target_length, patience, epoch,
                   warmup, gpu_type, res_fn, gradient_accumulation_steps, filename_end, prompt_len,prefix_middim,prompt_type,LMadaption,freeze)
        else:
            cmd_str = 'bash exp_with_args_prefix_fewshot.sh %s %s %s %d %d %d %d %d %d %d %d %d %s %s %d %s %d %d %d %s %d %d %d' % \
                  (task, sub_task, model_tag, gpu, data_num, bs, lr, source_length, target_length, patience, epoch,
                   warmup, gpu_type, res_fn, gradient_accumulation_steps, filename_end, prompt_len,prefix_middim,prompt_type,few_shot,freeze,LMadaption,test)


    return cmd_str


def get_args_by_task_model(task, sub_task, model_tag):
    if task == 'translate':
        # java-cs: Read 10300 examples, avg src len: 13, avg trg len: 15, max src len: 136, max trg len: 118
        # [TOKENIZE] avg src len: 45, avg trg len: 56, max src len: 391, max trg len: 404
        src_len = 320
        trg_len = 256
        epoch = 100
        patience = 5
    elif task == 'summarize':
        # ruby: Read 24927 examples, avg src len: 66, avg trg len: 12, max src len: 501, max trg len: 146
        # [TOKENIZE] avg src len: 100, avg trg len: 13, max src len: 1250, max trg len: 161
        # Python: Read 251820 examples, avg src len: 100, avg trg len: 11, max src len: 512, max trg len: 222
        # [TOKENIZE] avg src len: 142, avg trg len: 12, max src len: 2016, max trg len: 245
        # Javascript: Read 58025 examples, avg src len: 114, avg trg len: 11, max src len: 512, max trg len: 165
        # [TOKENIZE] avg src len: 136, avg trg len: 12, max src len: 3016, max trg len: 177
        src_len = 256
        trg_len = 128
        epoch = 15
        patience = 2
    elif task == 'refine':
        # small: Read 46680 examples, avg src len: 31, avg trg len: 28, max src len: 50, max trg len: 50
        # [TOKENIZE] avg src len: 50, avg trg len: 45, max src len: 129, max trg len: 121
        # medium:  Read 52364 examples, avg src len: 74, avg trg len: 73, max src len: 100, max trg len: 100
        # [TOKENIZE] avg src len: 117, avg trg len: 114, max src len: 238, max trg len: 238
        if sub_task == 'small':
            src_len = 130
            trg_len = 120
        elif sub_task == 'medium':
            src_len = 240
            trg_len = 240
        epoch = 50
        patience = 5
    elif task == 'concode':
        # Read 100000 examples, avg src len: 71, avg trg len: 26, max src len: 567, max trg len: 140
        # [TOKENIZE] avg src len: 213, avg trg len: 33, max src len: 2246, max trg len: 264
        src_len = 320
        trg_len = 150
        epoch = 30
        patience = 3
    elif task == 'defect':
        # Read 21854 examples, avg src len: 187, avg trg len: 1, max src len: 12195, max trg len: 1
        # [TOKENIZE] avg src len: 597, avg trg len: 1, max src len: 41447, max trg len: 1
        src_len = 512
        trg_len = 3
        epoch = 10
        patience = 2
    elif task == 'clone':
        # Read 901028 examples, avg src len: 120, avg trg len: 123, max src len: 5270, max trg len: 5270
        # [TOKENIZE] avg src len: 318, avg trg len: 323, max src len: 15111, max trg len: 15111
        src_len = 400
        trg_len = 400
        epoch = 2
        patience = 1

    if 'codet5_small' in model_tag:
        bs = 32
        if task == 'summarize' or task == 'translate' or (task == 'refine' and sub_task == 'small'):
            bs = 32
            #bs=64
    else:
        bs = 32
        if task == 'translate':
            # bs = 25
            bs=12
        elif task == 'summarize':
            bs = 16
    lr = 5
    if task == 'concode':
        lr = 10
    elif task == 'defect':
        lr = 2
    #test
    if task=='summarize' and sub_task=='java':
        lr=10
    return bs, lr, src_len, trg_len, patience, epoch


def run_one_exp(args):
    bs, lr, src_len, trg_len, patience, epoch = get_args_by_task_model(args.task, args.sub_task, args.model_tag)
    if args.patience != -1:
        patience = args.patience
    if args.epoch != -1:
        epoch = args.epoch
    if args.bs != -1:
        bs=args.bs

    if args.lr != -1:
        lr=args.lr
    print('============================Start Running==========================')
    cmd_str = get_cmd(task=args.task, sub_task=args.sub_task, model_tag=args.model_tag, gpu=args.gpu,
                      data_num=args.data_num, bs=bs, lr=lr, source_length=src_len, target_length=trg_len,
                      patience=patience, epoch=epoch, warmup=1000, gpu_type=args.gpu_type,
                      res_fn='{}/{}_{}.txt'.format(args.res_dir, args.task, args.model_tag),
                      gradient_accumulation_steps=args.gradient_accumulation_steps,
                      filename_end=args.filename_end,prompt_len=args.prompt_len,prompt_type=args.prompt_type,prefix_middim=args.prefix_middim,few_shot=args.few_shot,freeze=args.freeze,LMadaption=args.LMadaption, test=args.test)
    print('%s\n' % cmd_str)
    os.system(cmd_str)


def get_sub_tasks(task):
    if task == 'summarize':
        sub_tasks = ['ruby', 'javascript', 'go', 'python', 'java', 'php','smartContract']
    elif task == 'translate':
        sub_tasks = ['java-cs', 'cs-java','java-cpp','cpp-java','java-python','python-java','java-go','go-java','python-go','go-python']
    elif task == 'refine':
        sub_tasks = ['small', 'medium']
    else:
        sub_tasks = ['none']

    return sub_tasks


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("--model_tag", type=str, default='codet5_base',
                        choices=['roberta', 'codebert', 'bart_base', 'codet5_small', 'codet5_base'])
    parser.add_argument("--task", type=str, default='summarize', choices=['summarize', 'concode', 'translate',
                                                                          'refine', 'defect', 'clone'])
    parser.add_argument("--sub_task", type=str, default='ruby')
    parser.add_argument("--res_dir", type=str, default='results')
    parser.add_argument("--gpu_type", type=str, default='a100', choices=['v100', 'a100'])
    parser.add_argument("--data_num", type=int, default=-1)
    parser.add_argument("--gpu", type=int, default=0)
    parser.add_argument("--gradient_accumulation_steps",type=int,default=1)
    parser.add_argument("--filename_end", type=str, default='')
    parser.add_argument("--prompt_len", type=int, default=0)
    parser.add_argument("--prompt_type", type=int, default=0, help="0 for softprompt, 1 for encoder prefix,2for en/decoder prefix when prompt_len=0, "
                                                                   "finetune")
    parser.add_argument("--patience", type=int, default=-1)
    parser.add_argument("--epoch", type=int, default=-1)
    parser.add_argument("--bs", type=int, default=-1)
    parser.add_argument("--lr", type=int, default=-1)

    parser.add_argument("--few_shot", type=str, default='0')
    parser.add_argument("--prefix_middim", type=int, default=512, help=" middim of mlp in prefixencoder ")
    parser.add_argument("--freeze", type=int, default=1)
    parser.add_argument("--LMadaption", type=int, default=0)

    #if test==1, only do test.
    parser.add_argument("--test", type=int, default=0)


    args = parser.parse_args()

    if not os.path.exists(args.res_dir):
        os.makedirs(args.res_dir)

    assert args.sub_task in get_sub_tasks(args.task)
    run_one_exp(args)
