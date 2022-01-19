python ./run_gen_prefix.py --do_test --do_train --do_eval --do_eval_bleu --save_last_checkpoints --always_save_model --task summarize --sub_task java --model_type codet5 --data_num -1 --num_train_epochs 15 --warmup_steps 1000 --learning_rate 10e-5 --patience 2 --tokenizer_name=roberta-base --model_name_or_path=../pretrained_models/codet5_base --output_dir saved_models/summarize/java/codet5_base_all_lr10_bs16_src256_trg128_pat2_e15_gradientAccumulationSteps1_finetune_prefixlen0_prefixmiddim512_promptType3 --data_dir /mnt/sda/ys/codeT5/CodeT5/data --cache_path saved_models/summarize/java/codet5_base_all_lr10_bs16_src256_trg128_pat2_e15_gradientAccumulationSteps1_finetune_prefixlen0_prefixmiddim512_promptType3/cache_data --res_dir saved_models/summarize/java/codet5_base_all_lr10_bs16_src256_trg128_pat2_e15_gradientAccumulationSteps1_finetune_prefixlen0_prefixmiddim512_promptType3/prediction --res_fn results/summarize_codet5_base.txt --train_batch_size 16 --eval_batch_size 16 --max_source_length 256 --max_target_length 128 --gradient_accumulation_steps 1 --prompt_len 0 --prompt_type 3 --prefix_middim 512 --gpu 1 2>&1 | tee saved_models/summarize/java/codet5_base_all_lr10_bs16_src256_trg128_pat2_e15_gradientAccumulationSteps1_finetune_prefixlen0_prefixmiddim512_promptType3/train.log

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot5000 --prompt_len 100 --prompt_type 3 --patience 50 --few_shot 5000 --epoch 10000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot5000 --prompt_len 0 --prompt_type 3 --patience 50 --few_shot 5000 --epoch 10000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot1000 --prompt_len 100 --prompt_type 3 --patience 100 --few_shot 1000 --epoch 10000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot1000 --prompt_len 0 --prompt_type 3 --patience 100 --few_shot 1000 --epoch 10000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot500 --prompt_len 100 --prompt_type 3 --patience 100 --few_shot 500 --epoch 10000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot500 --prompt_len 0 --prompt_type 3 --patience 100 --few_shot 500 --epoch 10000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot100 --prompt_len 100 --prompt_type 3 --patience 500 --few_shot 100 --epoch 20000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot100 --prompt_len 0 --prompt_type 3 --patience 500 --few_shot 100 --epoch 20000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot32 --prompt_len 150 --prompt_type 3 --patience 1000 --few_shot 32 --epoch 50000 --bs 16

python run_exp_softprompt.py --model_tag codet5_base --task summarize --sub_task java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot32 --prompt_len 0 --prompt_type 3 --patience 1000 --few_shot 32 --epoch 50000 --bs 16
