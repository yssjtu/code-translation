import csv
import os
import re


def summary_exp_results(task,subtask,prefix,infix,outname):
    mids=["finetune_prefixlen0","prefix_prefixlen100","lmadaption1_prefixlen100","lmadaption2_finetune_prefixlen0","lmadaption2_prefix_prefixlen100","lmadaption3_prefixlen100"]

    # 表头
    field_order = ["mehtod", '[best-bleu]-bleu','[best-ppl]-bleu','[last]-bleu', '[best-bleu]-em','[best-ppl]-em','[last]-em', '[best-bleu]-codebleu','[best-ppl]-codebleu','[last]-codebleu','params']
    if not os.path.exists("/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv"):
        os.makedirs("/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv")
    outfile="/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv/"+outname+".csv"
    path="/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask
    with open(outfile, 'w', encoding="utf-8", newline='') as csvfile:
        writer = csv.DictWriter(csvfile, field_order)
        writer.writeheader()
        for mid in mids:
            row=[]
            row.append(mid)
            with open(path+"/"+prefix+mid+infix+"/summary.log", encoding="utf-8")as f:
                scores = []
                for idx, line in enumerate(f):
                    if "[best-bleu]" in line or "[best-ppl]" in line or "[last]" in line:
                        tmp_scores=re.findall("\d+\.\d+", line)
                        scores.append(tmp_scores)
                #重新跑的实验，最后三行才是准确结果
                scores=scores[-3:]
                for i in range(3):
                    for j in range(3):
                        row.append(float(scores[j][i]))
            row.append(prefix)
            writer.writerow(dict(zip(field_order, row)))

def summary_exp_results_new(task,subtask,prefix,infix,outname):
    mids=["finetune_prefixlen0","prefix_prefixlen100","lmadaption2_finetune_prefixlen0","lmadaption2_prefix_prefixlen100"]

    # 表头
    field_order = ["mehtod", 'Bleu-4', 'Acc', 'CodeBLEU']
    if not os.path.exists("/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv"):
        os.makedirs("/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv")
    outfile="/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv/"+outname+".csv"
    path="/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask
    with open(outfile, 'w', encoding="utf-8", newline='') as csvfile:
        writer = csv.DictWriter(csvfile, field_order)
        writer.writeheader()
        for mid in mids:
            row=[]
            row.append(mid)
            with open(path+"/"+prefix+mid+infix+"/summary.log", encoding="utf-8")as f:
                scores = []
                for idx, line in enumerate(f):
                    if "[best-bleu]" in line or "[best-ppl]" in line or "[last]" in line:
                        tmp_scores=re.findall("\d+\.\d+", line)
                        scores.append(tmp_scores)
                #重新跑的实验，最后三行才是准确结果
                scores=scores[-3:]
                best_score=scores[0]
                for i in range(2):
                    if(float(scores[i+1][0])>=float(best_score[0])):
                        best_score=scores[i+1]
                for j in range(3):
                    row.append(float(best_score[j]))
            # row.append(prefix)
            writer.writerow(dict(zip(field_order, row)))


def summary_exp_results_datasize_ablation(task,subtask,prefix,infix,outname):
    mids=["finetune_prefixlen0","prefix_prefixlen100","lmadaption2_finetune_prefixlen0","lmadaption2_prefix_prefixlen100"]

    # 表头
    field_order = ["mehtod", 'Bleu-4', 'Acc', 'CodeBLEU']
    if not os.path.exists("/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv"):
        os.makedirs("/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv")
    outfile="/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask+"/results_csv/"+outname+".csv"
    path="/mnt/sda/ys/codeT5/CodeT5/sh/saved_models/"+task+"/"+subtask
    with open(outfile, 'w', encoding="utf-8", newline='') as csvfile:
        writer = csv.DictWriter(csvfile, field_order)
        writer.writeheader()
        for mid in mids:
            row=[]
            row.append(mid)
            with open(path+"/"+prefix+mid+infix+"/summary.log", encoding="utf-8")as f:
                scores = []
                for idx, line in enumerate(f):
                    if "[best-bleu]" in line or "[best-ppl]" in line or "[last]" in line:
                        tmp_scores=re.findall("\d+\.\d+", line)
                        scores.append(tmp_scores)
                #重新跑的实验，最后三行才是准确结果
                scores=scores[-3:]
                best_score=scores[0]
                for i in range(2):
                    if(float(scores[i+1][0])>=float(best_score[0])):
                        best_score=scores[i+1]
                for j in range(3):
                    row.append(float(best_score[j]))
            # row.append(prefix)
            writer.writerow(dict(zip(field_order, row)))
# summary_exp_results("translate","java-python","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_1_TransCoderData_","_prefixmiddim512_promptType3","fewshot32_1_java-python_re")
# summary_exp_results("translate","python-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_1_TransCoderData_","_prefixmiddim512_promptType3","fewshot32_python-java_re")
# summary_exp_results("translate","cs-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_1_","_prefixmiddim512_promptType3","fewshot32_1_cs-java_re")
# summary_exp_results("translate","java-cs","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_1_","_prefixmiddim512_promptType3","fewshot32_1_java-cs_re")
# # summary_exp_results("translate","java-go","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_100_LeetcodeData_","_prefixmiddim512_promptType3","fewshot32_1_java-go_re")
# summary_exp_results("translate","python-go","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_100_LeetcodeData_","_prefixmiddim512_promptType3","fewshot32_1_python-go_re")
#
# # summary_exp_results("translate","go-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_1_LeetcodeData_","_prefixmiddim512_promptType3","fewshot32_1_go_java_re")
# summary_exp_results("translate","go-python","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_1_LeetcodeData_","_prefixmiddim512_promptType3","fewshot32_1_go-python_re")
#
# summary_exp_results("translate","go-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_2_LeetcodeData_","_prefixmiddim512_promptType3","fewshot32_2_go_java_re")
# summary_exp_results("translate","java-go","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_2_LeetcodeData_","_prefixmiddim512_promptType3","fewshot32_2_java-go_re")





# summary_exp_results("translate","java-cs","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_sampleFromValidTrain_1_","_prefixmiddim512_promptType3","fewshot32_sampelfromvalidtrain_1_java-cs")
# summary_exp_results("translate","java-cs","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_2_","_prefixmiddim512_promptType3","fewshot32_2_java-cs")
#
# summary_exp_results("translate","java-cs","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_32_sampleFromValidTrain_2_","_prefixmiddim512_promptType3","fewshot32_samplefromvalidtrain_2_java-cs")




summary_exp_results_new("translate","java-cs","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_datasize_ablation_fewshot_8_","_prefixmiddim512_promptType3","fewshot8_java-cs")
summary_exp_results_new("translate","java-python","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_datasize_ablation_fewshot_8_TransCoderData_","_prefixmiddim512_promptType3","fewshot8_java-python")
summary_exp_results_new("translate","cs-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_8_","_prefixmiddim512_promptType3","fewshot8_cs-java")
summary_exp_results_new("translate","python-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_8_TransCoderData_","_prefixmiddim512_promptType3","fewshot8_python-java")
summary_exp_results_new("translate","java-go","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_8_LeetcodeData_","_prefixmiddim512_promptType3","fewshot8_java-go")
summary_exp_results_new("translate","go-java","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_8_LeetcodeData_","_prefixmiddim512_promptType3","fewshot8_go-java")
summary_exp_results_new("translate","python-go","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_8_LeetcodeData_","_prefixmiddim512_promptType3","fewshot8_python-go")
summary_exp_results_new("translate","go-python","codet5_base_all_lr5_bs12_src320_trg256_pat300_e10000_gradientAccumulationSteps1_fewshot_8_LeetcodeData_","_prefixmiddim512_promptType3","fewshot8_go-python")


