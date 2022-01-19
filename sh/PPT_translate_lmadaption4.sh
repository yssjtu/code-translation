#python ./run_gen_prefix.py  --do_train  --save_last_checkpoints --always_save_model --task translate --sub_task java-cs --model_type codet5 --data_num -1 --num_train_epochs 3 --warmup_steps 1000 --learning_rate 5e-5 --patience 5 --tokenizer_name=roberta-base --model_name_or_path=../pretrained_models/codet5_base --output_dir saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption4_prefixlen100_prefixmiddim512_promptType3 --data_dir /mnt/sda/ys/codeT5/CodeT5/data_sample_-1 --cache_path saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption4_prefixlen100_prefixmiddim512_promptType3/cache_data --res_dir saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption4_prefixlen100_prefixmiddim512_promptType3/prediction --res_fn results/translate_codet5_base.txt --train_batch_size 12 --eval_batch_size 12 --max_source_length 320 --max_target_length 256 --gradient_accumulation_steps 1 --prompt_len 100 --prompt_type 3 --prefix_middim 512 --gpu 0 --freeze 1 --LMadaption 2 --few_shot -1 2>&1 |tee saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e3_gradientAccumulationSteps1_LMadaption4_prefixlen100_prefixmiddim512_promptType3/train.log
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_5000_lmadaption4_prefix --prompt_len 100 --prompt_type 3 --few_shot 5000 --patience 10 --epoch 10000 --LMadaption 4
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_1000_lmadaption4_prefix --prompt_len 100 --prompt_type 3 --few_shot 1000 --patience 50 --epoch 10000 --LMadaption 4
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_500_lmadaption4_prefix --prompt_len 100 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 4
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_100_lmadaption4_prefix --prompt_len 100 --prompt_type 3 --few_shot 100 --patience 200 --epoch 10000 --LMadaption 4
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_lmadaption4_prefix --prompt_len 100 --prompt_type 3 --few_shot 32 --patience 300 --epoch 10000 --LMadaption 4
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_5000_finetune --prompt_len 0 --prompt_type 3 --few_shot 5000 --patience 10 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_1000_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 50 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_500_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_finetune --prompt_len 0 --prompt_type 3 --few_shot 32 --patience 300 --epoch 10000


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 3

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_2 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_2 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_2_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_2 --patience 300 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_2_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_2 --patience 300 --epoch 10000 --LMadaption 3

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_2_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_2 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_2_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_2 --patience 300 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_1_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_sampleFromValidTrain_1 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_1_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_1 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_1_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_1 --patience 300 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_1_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_1 --patience 300 --epoch 10000 --LMadaption 3

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_1_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_1 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_1_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_sampleFromValidTrain_1 --patience 300 --epoch 10000 --LMadaption 2



python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_sampleFromValidTrain_2 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_2 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_2_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_2 --patience 300 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_2_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_2 --patience 300 --epoch 10000 --LMadaption 3

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_2_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_sampleFromValidTrain_2 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_sampleFromValidTrain_2_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_sampleFromValidTrain_2 --patience 300 --epoch 10000 --LMadaption 2
