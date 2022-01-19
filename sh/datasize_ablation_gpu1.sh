#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000 --LMadaption 2
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_finetune --prompt_len 0 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000 --LMadaption 2
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_full_finetune --prompt_len 0 --prompt_type 3 --few_shot full --patience 10 --epoch 10000


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_full_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot full --patience 10 --epoch 10000 --LMadaption 2 --freeze 0





#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
#
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --freeze 0
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000
#
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000 --LMadaption 2 --freeze 0
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_finetune --prompt_len 0 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000
#
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000
#
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0
#
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000
#
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0
