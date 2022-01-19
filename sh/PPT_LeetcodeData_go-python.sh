
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task go-python --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_LeetcodeData_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task go-python --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_LeetcodeData_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task go-python --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_LeetcodeData_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task go-python --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_LeetcodeData_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 3

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task go-python --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_LeetcodeData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task go-python --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_LeetcodeData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 2
