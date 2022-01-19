python ./run_gen_prefix.py --do_test --do_train --do_eval --do_eval_bleu --save_last_checkpoints --always_save_model --task translate --sub_task java-cs --model_type codet5 --data_num -1 --num_train_epochs 100 --warmup_steps 1000 --learning_rate 5e-5 --patience 5 --tokenizer_name=roberta-base --model_name_or_path=../pretrained_models/codet5_base --output_dir saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen100_prefixmiddim512_promptType3 --data_dir /mnt/sda/ys/codeT5/CodeT5/data --cache_path saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen100_prefixmiddim512_promptType3/cache_data --res_dir saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen100_prefixmiddim512_promptType3/prediction --res_fn results/translate_codet5_base.txt --train_batch_size 12 --eval_batch_size 12 --max_source_length 320 --max_target_length 256 --gradient_accumulation_steps 2 --prompt_len 100 --prompt_type 3 --prefix_middim 512 --gpu 1 2>&1 | tee saved_models/translate/java-cs/codet5_base_all_lr5_bs12_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen100_prefixmiddim512_promptType3/train.log

python ./run_gen_prefix.py --do_test --do_train --do_eval --do_eval_bleu --save_last_checkpoints --always_save_model --task translate --sub_task java-cs --model_type codet5 --data_num -1 --num_train_epochs 100 --warmup_steps 1000 --learning_rate 5e-5 --patience 5 --tokenizer_name=roberta-base --model_name_or_path=../pretrained_models/codet5_small --output_dir saved_models/translate/java-cs/codet5_small_all_lr5_bs32_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen20_prefixmiddim512_promptType3 --data_dir /mnt/sda/ys/codeT5/CodeT5/data --cache_path saved_models/translate/java-cs/codet5_small_all_lr5_bs32_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen20_prefixmiddim512_promptType3/cache_data --res_dir saved_models/translate/java-cs/codet5_small_all_lr5_bs32_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen20_prefixmiddim512_promptType3/prediction --res_fn results/translate_codet5_small.txt --train_batch_size 32 --eval_batch_size 32 --max_source_length 320 --max_target_length 256 --gradient_accumulation_steps 2 --prompt_len 20 --prompt_type 3 --prefix_middim 512 --gpu 1 2>&1 | tee saved_models/translate/java-cs/codet5_small_all_lr5_bs32_src320_trg256_pat5_e100_gradientAccumulationSteps2_EnDePrefix_prefixlen20_prefixmiddim512_promptType3/train.log