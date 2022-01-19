#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2


#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 2 --test 1
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 2 --test 1
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --test 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_TransCoderData_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 1 --test 1
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_TransCoderData_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 3 --test 1






#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 1 --test 1

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 3 --test 1

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 1 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2



python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 1 --test 1
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_32_1_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 32_1 --patience 300 --epoch 10000 --LMadaption 3 --test 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2




python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_TransCoderData_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_TransCoderData_lmadaption1 --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 1 --test 1
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_TransCoderData_lmadaption3 --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 3 --test 1

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 1 --gradient_accumulation_steps 1 --filename_end fewshot_8_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2



