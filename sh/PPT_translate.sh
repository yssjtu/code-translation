#5000可能改大ps 重跑下试试
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_5000_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 5000 --patience 10 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_1000_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 1000 --patience 50 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_500_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_100_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 100 --patience 200 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_32_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32 --patience 300 --epoch 10000 --LMadaption 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end full_lmadaption1 --prompt_len 100 --prompt_type 3  --patience 30 --epoch 1000 --LMadaption 1
