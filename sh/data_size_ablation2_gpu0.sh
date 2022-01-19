
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2


python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_full_finetune --prompt_len 0 --prompt_type 3 --few_shot full --patience 10 --epoch 10000

python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task cs-java --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_full_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot full --patience 10 --epoch 10000 --LMadaption 2 --freeze 0

#

#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_lmadaption2_prefix_finetune --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --freeze 0 --bs 8
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000 --LMadaption 2
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_TransCoderData_lmadaption2_prefix_finetune --prompt_len 100 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000 --LMadaption 2 --freeze 0 --bs 8


#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-cs --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_full_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot full --patience 10 --epoch 10000 --LMadaption 2
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000
##
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_lmadaption2_prefix --prompt_len 100 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2
##
##python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_lmadaption2_prefix_finetune --prompt_len 100 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0 --bs 8
##
#
#
##python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_8_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2 --freeze 0
#
#
##python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_16_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 16 --patience 300 --epoch 10000 --LMadaption 2 --freeze 0
#
#
##python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_100_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 100 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0
#
#
##python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_1000_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 1000 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0
#
#
##python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000
#
#python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task java-python --gpu 0 --gradient_accumulation_steps 1 --filename_end datasize_ablation_fewshot_500_TransCoderData_lmadaption2_finetune --prompt_len 0 --prompt_type 3 --few_shot 500 --patience 100 --epoch 10000 --LMadaption 2 --freeze 0