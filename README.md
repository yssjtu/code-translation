# Few-Shot Code Translation with Prompt Learning


**Introduction**

We present FSCTrans, a novel few-shot learning based approach for low-resource code translation. FSCTrans is built upon CodeT5 [15], the state-of-the-art code PLM. FSCTrans adapts the CodeT5 to few-shot code translation via prompt learning. First, FSCTrans adapts the parallel code translation task to the monolingual pre-training tasks of CodeT5 using prefix language modeling. In order to transfer the pre-trained CodeT5 to scarce code translation data, FSCTrans leverages the prompt learning method, which only updates the parameters in the prompt module while freezing the entire CodeT5 model to retain the knowledge learned during pre-training.
To evaluate our approach, we build a few-shot code transla-tion dataset that involves four translations (i.e., Java→Pytyhon, Python→Java, Java→C#, and C#→Java) from real-world projects and online judge problems . We compare our approach with five baseline approaches, including simple copy, Transformer, CodeBERT, CodeT5, and TransCoder. Experi-mental results show that FSCTrans remarkably outperforms the state-of-the-art code translation models in few-shot set-tings. For example, FSCTrans achieves a BLEU score of 44.9, which is 74.4% greater than CodeT5 (BLEU = 25.74) in C#→Java translation.

Our contributions can be summarized as:
- We propose a novel few-shot code translation approach using prompt learning.
- We propose a task adaption method to bridge the gap between the PLM and the translation task.
- We evaluate our approach on a few-shot parallel codebase collected from real projects and online judge problems. Experiments have shown that our approach outperforms the state-of-the-art methods by a remarkable margin.

**Data**
Monolingual dataset for task adaption can be downloaded from [CodeSeachNet](https://github.com/github/CodeSearchNet#downloading-data-from-s3) ,
Train/valid/test data is under ./data_sample_8/translate/. The Java<->C# pairs are sampled from [CodeXGLUE](https://github.com/microsoft/CodeXGLUE/tree/main/Code-Code/code-to-code-trans), and the Java<->Python pairs are from [TransCoder](https://github.com/facebookresearch/TransCoder).

**Source Codes**
Source code for our prompt learning module is in [model.py](models.py). Source code for training is in [run_gen_prefix.py](sh/run_gen_prefix.py).

**Usage**
Go to the 'sh' folder, take the python->java translation as example,


Fine-tuning on the original codeT5:
```
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_LeetcodeData_finetune --prompt_len 0 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
```


Directly prompt learning on the original codeT5:
```
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_LeetcodeData_prefix --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000
```


FSCTrans:
```
python run_exp_softprompt.py --model_tag codet5_base --task translate --sub_task python-java --gpu 0 --gradient_accumulation_steps 1 --filename_end fewshot_8_LeetcodeData_FSCT --prompt_len 100 --prompt_type 3 --few_shot 8 --patience 300 --epoch 10000 --LMadaption 2
```



**Main Results**
![Results](main_results.png)

