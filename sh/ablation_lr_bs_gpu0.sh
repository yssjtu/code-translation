python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end bs8_ablation_fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --bs 8

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end bs4_ablation_fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --bs 4

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end lr1_ablation_fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --lr 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end lr20_ablation_fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --lr 20

