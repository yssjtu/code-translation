import json
import os
import random
import re
import csv
#reg for deleting /**/ comments:   /\*[\s\S]*?\*/

def check_contain_chinese(check_str):
    for ch in check_str:
        if u'\u4e00' <= ch <= u'\u9fff':
            return True
    return False

def replace(str):

    replacestr=['(',')','[',']','{','}',',','.','>','<']
    for i in replacestr:
        pattern = re.compile(r'\s*['+i+']\s*')
        str=pattern.sub(i,str)

    str=str[:str.find("){")+1]+" "+str[str.find("){")+1:]

    # str=str.replace("){",") {")
    str=str.replace(",",", ")
    str=str.replace(">","> ")
    str=str.replace("> >",">>")
    str=str.replace("> (",">(")
    return  str

def clean_java():

    f_src1 = open("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/code_tokens.java", 'w',
                 encoding='utf-8')
    f_src2 = open("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/codes.java", 'w',
                  encoding='utf-8')
    for i in range(16):
        print("dealing with "+str(i)+" th file...")
        src_file = "/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/" + "java_train_" + str(i) + ".jsonl"
        with open(src_file, encoding="utf-8") as f:
            for idx, line in enumerate(f):
                line = line.strip()
                try:
                    line.encode('utf-8')
                except UnicodeDecodeError:
                    continue

                js = json.loads(line)

                code_tokens = js['code_tokens']
                annotation_idx = []

                for n in range(len(code_tokens)):


                    if len(code_tokens[n]) == 0:
                        annotation_idx.append(n)
                    else:

                        first2_char = code_tokens[n][0:2]
                        last_char = code_tokens[n][-1]
                        first3_char = code_tokens[n][0:3]
                        last3_char = code_tokens[n][-3:]
                        if first2_char == '//' or first2_char=='/*':
                            annotation_idx.append(n)

                        if first3_char == "'''" or first3_char == '"""' or last3_char == "'''" or last3_char == '"""':
                            annotation_idx.append(n)

                        # if first_char == '"' or last_char == '"' or first_char == "'" or last_char == '"':
                        #     code_tokens[n] = " ".join(token.split())


                for m in range(len(annotation_idx)):
                    del code_tokens[annotation_idx[m] - m]

                if(len(code_tokens)<=4):
                    continue


                code_token = ' '.join(code_tokens)
                code_token = ' '.join(code_token.split())
                if check_contain_chinese(code_token):
                    continue
                code_token=replace(code_token)
                # code_token=code_token.replace("}","} ")
                # pattern = re.compile(r'}\n}')
                # code_token = pattern.sub("}} ", code_token)


                code=js['code']
                pattern = re.compile(r'//.*\n')
                code = pattern.sub(" ", code)

                code = ' '.join(code.split())
                pattern = re.compile(r'/\*.+?\*/')
                code = pattern.sub(" ", code)
                if(code.find('/*') != -1):
                    continue

                f_src1.write(code_token+'\n')
                f_src2.write(code+'\n')
    f_src1.close()
    f_src2.close()
    print("done..")

def clean_csharp():
    f_out=open("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/codes.cs", 'w',
                 encoding='utf-8')

    src_file = "/mnt/sda/ys/codeT5/CodeT5/data/csharp_github/train.txt"
    with open(src_file, encoding="utf-8") as f:
        for idx, line in enumerate(f):
            line = line.strip()
            try:
                line.encode('utf-8')
            except UnicodeDecodeError:
                continue
            if check_contain_chinese(line):
                continue


            line=line[line.rfind("<CODESPLIT>")+11:]
            if check_contain_chinese(line):
                continue

            pattern = re.compile(r'/\*.*\*/')
            line = pattern.sub(" ", line)


            pattern = re.compile(r'//.*\n')
            line = pattern.sub(" ", line)
            line = ' '.join(line.split())

            idx=line.find(')')
            if idx==-1 or idx>=len(line)-2:
                continue
            if line[idx + 1] != '{' and line[idx + 2] != '{':
                continue

            if (len(line.split()) <= 4):
                continue

            f_out.write(line+'}'+'\n')
    f_out.close()
    print("done")
def unique(src_file):
    #src_file="/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/codes.cs"
    f_out = open(src_file+"_filtered", 'w',
                 encoding='utf-8')
    with open(src_file, encoding="utf-8") as f:
        lines=f.readlines()
        lines=list(set(lines))
        f_out.writelines(lines)
    f_out.close()
    print("done..")

def conbine(src1,src2):
    f_out = open("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/conbine.data",'w',encoding='utf-8')
    with open(src1,encoding="utf-8") as f:
        lines=f.readlines()
        lines=list(set(lines))
        f_out.writelines(lines)
    with open(src2,encoding="utf-8") as f:
        lines=f.readlines()
        lines=list(set(lines))
        f_out.writelines(lines)

    f_out.close()
    print("done")

def split_prefixLM():
    src="/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/conbine.data"
    f_out_src=open("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/src.combine",'w',encoding='utf-8')
    f_out_tgt=open("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/tgt.combine",'w',encoding='utf-8')
    with open(src,encoding="utf-8")as f:
        for idx, line in enumerate(f):
            line = line.strip()
            line_list=line.split()
            if(len(line_list)<15):
                splitidx = random.randint(int(len(line_list) * 0.6), int(len(line_list) * 0.75))
            else:
                splitidx=random.randint(int(len(line_list)*0.4),int(len(line_list)*0.75))
            f_out_src.write(" ".join(line_list[0:splitidx])+'\n')
            f_out_tgt.write(" ".join(line_list[splitidx:])+'\n')
    f_out_src.close()
    f_out_tgt.close()
def split_prefixLM_files(src,out_src,out_tgt):
    f_out_src=open(out_src,'w',encoding='utf-8')
    f_out_tgt=open(out_tgt,'w',encoding='utf-8')
    with open(src,encoding="utf-8")as f:
        for idx, line in enumerate(f):
            line = line.strip()
            line_list=line.split()
            if(len(line_list)<15):
                splitidx = random.randint(int(len(line_list) * 0.6), int(len(line_list) * 0.75))
            else:
                splitidx=random.randint(int(len(line_list)*0.4),int(len(line_list)*0.75))
            f_out_src.write(" ".join(line_list[0:splitidx])+'\n')
            f_out_tgt.write(" ".join(line_list[splitidx:])+'\n')
    f_out_src.close()
    f_out_tgt.close()

def extract_smart_contract():
    comments_root="/mnt/sda/ys/codeT5/CodeT5/data/smartContract/contracts/comments_v11162020"
    funcs_root="/mnt/sda/ys/codeT5/CodeT5/data/smartContract/contracts/funcs_comments_v11122020"
    f_out=open("/mnt/sda/ys/codeT5/CodeT5/data/smartContract/data.jsonl",'w',encoding='utf-8')
    for i in range(1,42):
        contract="/contract"+str(i)
        for root,dirs,files in os.walk(funcs_root+contract):
            for file in files:
                json_data = {}
                with open(funcs_root+contract+"/"+file,encoding="utf-8")as f:
                    lines=f.readlines()
                    line="".join(lines)
                    pattern = re.compile(r'//.*\n')
                    line = pattern.sub(" ", line)

                    pattern = re.compile(r'/\*[\s\S]*?\*/')
                    line = pattern.sub(" ", line)

                    line = ' '.join((line.strip()).split())
                    json_data['code'] = line
                with open(comments_root+contract+"/"+file[:-4]+"_comm.txt",encoding="utf-8")as f:
                    lines=f.readlines()
                    line="".join(lines)
                    line=' '.join((line.strip()).split())
                    json_data['summary'] = line
                json_data=json.dumps(json_data)
                f_out.write(json_data+'\n')
        print(contract+" done...")
    f_out.close()
def splite_data(src):
        sources = [
            x for x in open(src, 'r', encoding='utf-8').readlines()]
        random.shuffle(sources)

        line=sources[0]
        line = line.strip()
        js = json.loads(line)
        code = ' '.join(js["code"].strip().split())
        nl = ' '.join(js["summary"].strip().split())

        f_train=open(src[:-10]+"train.jsonl",'w',encoding="utf-8")
        f_valid = open(src[:-10] + "valid.jsonl", 'w', encoding="utf-8")
        f_test = open(src[:-10] + "test.jsonl", 'w', encoding="utf-8")
        f_test.writelines(sources[0:int(len(sources)*0.05)])
        f_valid.writelines(sources[int(len(sources)*0.05):int(len(sources)*0.1)])
        f_train.writelines(sources[int(len(sources)*0.1):])
        f_train.close()
        f_test.close()
        f_valid.close()


def sample_sc_data(few_shot_num,train_num,valid_num):
    src="/mnt/sda/ys/codeT5/CodeT5/data/smartContract/train.jsonl"
    sources = [
        x for x in open(src, 'r', encoding='utf-8').readlines()]
    random.shuffle(sources)
    if not os.path.exists("/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(few_shot_num)+"/summarize/smartContract"):
        os.makedirs("/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(few_shot_num)+"/summarize/smartContract")
    f_train = open("/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(few_shot_num)+"/summarize/smartContract/train.jsonl", 'w', encoding="utf-8")
    f_valid = open("/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(few_shot_num)+"/summarize/smartContract/valid.jsonl", 'w', encoding="utf-8")

    f_train.writelines(sources[0:train_num])
    f_valid.writelines(sources[train_num+1:valid_num+train_num+1])
    f_train.close()
    f_valid.close()
    os.system(
        'cp ' + "/mnt/sda/ys/codeT5/CodeT5/data/smartContract/test.jsonl" + ' ' + "/mnt/sda/ys/codeT5/CodeT5/data_sample_" + str(
            few_shot_num) + "/summarize/smartContract/test.jsonl")

def sample_translate_data(few_shot_num,train_num,valid_num):
    src = "/mnt/sda/ys/codeT5/CodeT5/data/smartContract/train.jsonl"
    sources = [
        x for x in open(src, 'r', encoding='utf-8').readlines()]
    random.shuffle(sources)
    if not os.path.exists("/mnt/sda/ys/codeT5/CodeT5/data_sample_" + str(few_shot_num) + "/summarize/smartContract"):
        os.makedirs("/mnt/sda/ys/codeT5/CodeT5/data_sample_" + str(few_shot_num) + "/summarize/smartContract")
    f_train = open(
        "/mnt/sda/ys/codeT5/CodeT5/data_sample_" + str(few_shot_num) + "/summarize/smartContract/train.jsonl", 'w',
        encoding="utf-8")
    f_valid = open(
        "/mnt/sda/ys/codeT5/CodeT5/data_sample_" + str(few_shot_num) + "/summarize/smartContract/valid.jsonl", 'w',
        encoding="utf-8")

    f_train.writelines(sources[0:train_num])
    f_valid.writelines(sources[train_num + 1:valid_num + train_num + 1])
    f_train.close()
    f_valid.close()
    os.system(
        'cp ' + "/mnt/sda/ys/codeT5/CodeT5/data/smartContract/test.jsonl" + ' ' + "/mnt/sda/ys/codeT5/CodeT5/data_sample_" + str(
            few_shot_num) + "/summarize/smartContract/test.jsonl")

def sanity_check(file1,file2):
    #check data leak
    with open(file1, encoding="utf-8")as f1:
        lines1=f1.readlines()
    with open(file2, encoding="utf-8")as f2:
        lines2=f2.readlines()
    count=0
    set1=set(lines1)
    for line2 in lines2:
        if line2 in set1:
           count+=1
    print(count)

def conbine_twofile(src1,src2,out):
    f_out = open(out,'w',encoding='utf-8')
    with open(src1,encoding="utf-8") as f:
        lines=f.readlines()
        f_out.writelines(lines)
    with open(src2,encoding="utf-8") as f:
        lines=f.readlines()
        f_out.writelines(lines)
    f_out.close()
    print("done")

def clean_TransCoder_data(src,out):
    f_out = open(out, 'w', encoding='utf-8')
    with open(src, encoding="utf-8") as f:
        for idx, line in enumerate(f):
            if(len(line)<=1):
                continue
            line= line[line.find('|')+1:]
            line=' '.join(line.split())
            f_out.write(line+'\n')

def sample_TransCoder_data(src_java,src_python,src_cpp, train_num,valid_num):
    lines_java= [
        x for x in open(src_java, 'r', encoding='utf-8').readlines()]
    lines_python = [
        x for x in open(src_python, 'r', encoding='utf-8').readlines()]
    lines_cpp = [
        x for x in open(src_cpp, 'r', encoding='utf-8').readlines()]

    if not os.path.exists("/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(train_num)+"/translate"):
        os.makedirs("/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(train_num)+"/translate")

    out_path="/mnt/sda/ys/codeT5/CodeT5/data_sample_"+str(train_num)+"/translate/"
    f_java_train = open(out_path+"cleanjava.data"+".train", 'w', encoding='utf-8')
    f_python_train = open(out_path+"cleanpython.data"+".train", 'w', encoding='utf-8')
    f_cpp_train = open(out_path+"cleancpp.data"+".train", 'w', encoding='utf-8')
    f_java_valid = open(out_path+"cleanjava.data"+".valid", 'w', encoding='utf-8')
    f_python_valid = open(out_path+"cleanpython.data"+".valid", 'w', encoding='utf-8')
    f_cpp_valid = open(out_path+"cleancpp.data"+".valid", 'w', encoding='utf-8')
    f_java_test = open(out_path+"cleanjava.data"+".test", 'w', encoding='utf-8')
    f_python_test = open(out_path+"cleanpython.data"+".test", 'w', encoding='utf-8')
    f_cpp_test = open(out_path+"cleancpp.data"+".test", 'w', encoding='utf-8')

    if len(lines_java)!=len(lines_python) or len(lines_java)!= len(lines_cpp) or len(lines_cpp)!=len(lines_python):
        print("data not parallel!!!!")
        return
    idxs = list(range(len(lines_java)))
    random.shuffle(idxs)
    for idx in idxs[0:train_num]:
        f_java_train.writelines(lines_java[idx])
        f_python_train.writelines(lines_python[idx])
        f_cpp_train.writelines(lines_cpp[idx])

    for idx in idxs[train_num:train_num+valid_num]:
        f_java_valid.writelines(lines_java[idx])
        f_python_valid.writelines(lines_python[idx])
        f_cpp_valid.writelines(lines_cpp[idx])

    for idx in idxs[train_num+valid_num:]:
        f_java_test.writelines(lines_java[idx])
        f_python_test.writelines(lines_python[idx])
        f_cpp_test.writelines(lines_cpp[idx])

def clean_codeSearchNet_java(path):
    out1 = open(path + "/java.code_token", 'w', encoding='utf-8')
    out2= open(path+ "/java.src_code","w",encoding='utf-8')
    for root, dirs, files in os.walk(path):
        for file in files:
            if file == "java.code_token" or file == "java.src_code" or file == "java.code_token_filtered" or file == "java.src_code_filtered":
                continue
            with open(path + "/" + file, encoding="utf-8")as f:
                for idx, line in enumerate(f):
                    line = line.strip()
                    try:
                        line.encode('utf-8')
                    except UnicodeDecodeError:
                        continue
                    if (len(line) < 4):
                        continue
                    js = json.loads(line)

                    code_tokens = js['code_tokens']
                    annotation_idx = []

                    for n in range(len(code_tokens)):
                        if len(code_tokens[n]) == 0:
                            annotation_idx.append(n)
                        else:
                            first2_char = code_tokens[n][0:2]
                            last_char = code_tokens[n][-1]
                            first3_char = code_tokens[n][0:3]
                            last3_char = code_tokens[n][-3:]
                            if first2_char == '//' or first2_char == '/*':
                                annotation_idx.append(n)
                            if first3_char == "'''" or first3_char == '"""' or last3_char == "'''" or last3_char == '"""':
                                annotation_idx.append(n)
                            # if first_char == '"' or last_char == '"' or first_char == "'" or last_char == '"':
                            #     code_tokens[n] = " ".join(token.split())

                    for m in range(len(annotation_idx)):
                        del code_tokens[annotation_idx[m] - m]

                    if (len(code_tokens) <= 4):
                        continue

                    code_token = ' '.join(code_tokens)
                    code_token = ' '.join(code_token.split())
                    if check_contain_chinese(code_token):
                        continue

                    # code_token = code_token.replace('. ', '.').replace(' .', '.')
                    # code_token = code_token.replace('> >', '>>').replace('< <', '<<')

                    # code_token=code_token.replace("}","} ")
                    # pattern = re.compile(r'}\n}')
                    # code_token = pattern.sub("}} ", code_token)





                    code = js['code']
                    pattern = re.compile(r'//.*\n')
                    code = pattern.sub(" ", code)

                    code = ' '.join(code.split())
                    pattern = re.compile(r'/\*[\s\S]*?\*/')
                    code = pattern.sub(" ", code)

                    code = " ".join(code.split())

                    out1.write(code_token + '\n')
                    out2.write(code + '\n')
            print(file + "  done...")
    out1.close()
    out2.close()

    unique(path + "/java.code_token")
    unique(path+ "/java.src_code")

    print("unique done")
def clean_codeSearchNet_python(path):
    out1=open(path+"/python.code_token",'w', encoding='utf-8')
    out2=open(path+"/python.src_code",'w', encoding='utf-8')
    for root, dirs, files in os.walk(path):
        for file in files:
            if file=="python.code_token" or file=="python.src_code" or file=="python.code_token_filtered" or file=="python.src_code_filtered" :
                continue
            with open(path+ "/" + file, encoding="utf-8")as f:
                for idx, line in enumerate(f):
                    line = line.strip()
                    try:
                        line.encode('utf-8')
                    except UnicodeDecodeError:
                        continue
                    if(len(line)<4):
                        continue
                    js = json.loads(line)

                    code_tokens = js['code_tokens']
                    annotation_idx = []

                    for n in range(len(code_tokens)):
                        if len(code_tokens[n]) == 0:
                            annotation_idx.append(n)
                        else:

                            first2_char = code_tokens[n][0:2]
                            last_char = code_tokens[n][-1]
                            first3_char = code_tokens[n][0:3]
                            last3_char = code_tokens[n][-3:]
                            if code_tokens[n][0]=='#':
                                annotation_idx.append(n)
                            if first3_char == "'''" or first3_char == '"""' or last3_char == "'''" or last3_char == '"""':
                                annotation_idx.append(n)
                            # if first_char == '"' or last_char == '"' or first_char == "'" or last_char == '"':
                            #     code_tokens[n] = " ".join(token.split())

                    # 删除后 idx是变化的
                    for m in range(len(annotation_idx)):
                        del code_tokens[annotation_idx[m] - m]

                    if (len(code_tokens) <= 4):
                        continue

                    code_token = ' '.join(code_tokens)
                    code_token = ' '.join(code_token.split())
                    if check_contain_chinese(code_token):
                        continue
                        #transcoder这里为什么python不和java cpp一致，调用.前后都加上空格呢？？
                    # code_token = code_token.replace('. ', '.').replace(' .', '.')
                    # code_token = code_token.replace('> >', '>>').replace('< <', '<<')

                    # code_token=code_token.replace("}","} ")
                    # pattern = re.compile(r'}\n}')
                    # code_token = pattern.sub("}} ", code_token)

                    code = js['code']
                    pattern = re.compile(r'#.*\n')
                    code = pattern.sub(" ", code)

                    code = ' '.join(code.split())
                    pattern = re.compile(r'\"\"\"[\s\S]+?\"\"\"')
                    code = pattern.sub(" ", code)

                    code= " ".join(code.split())

                    out1.write(code_token + '\n')
                    out2.write(code + '\n')
            print(file+"  done...")
    out1.close()
    out2.close()
    unique(path+"/python.code_token")
    unique(path+"/python.src_code")
    print("unique done")

#clean codesearchnet data for LMadaption for leetcode data(java-go and python -go)
def clean_codeSearchNet_go(path):
    out1 = open(path + "/go.code_token", 'w', encoding='utf-8')
    out2= open(path+ "/go.src_code",'w',encoding='utf-8')
    for root, dirs, files in os.walk(path):
        for file in files:
            if file == "go.code_token" or file == "go.src_code" or file == "go.code_token_filtered" or file == "go.src_code_filtered":
                continue
            with open(path + "/" + file, encoding="utf-8")as f:
                for idx, line in enumerate(f):
                    line = line.strip()
                    try:
                        line.encode('utf-8')
                    except UnicodeDecodeError:
                        continue
                    if (len(line) < 4):
                        continue
                    js = json.loads(line)

                    code_tokens = js['code_tokens']
                    annotation_idx = []

                    for n in range(len(code_tokens)):

                        if len(code_tokens[n]) == 0:
                            annotation_idx.append(n)
                        else:
                            first2_char = code_tokens[n][0:2]
                            last_char = code_tokens[n][-1]
                            first3_char = code_tokens[n][0:3]
                            last3_char = code_tokens[n][-3:]
                            if first2_char == '//' or first2_char == '/*':
                                annotation_idx.append(n)
                            if first3_char == "'''" or first3_char == '"""' or last3_char == "'''" or last3_char == '"""':
                                annotation_idx.append(n)
                            # if first_char == '"' or last_char == '"' or first_char == "'" or last_char == '"':
                            #     code_tokens[n] = " ".join(token.split())

                    for m in range(len(annotation_idx)):
                        del code_tokens[annotation_idx[m] - m]

                    if (len(code_tokens) <= 4):
                        continue

                    code_token = ' '.join(code_tokens)
                    code_token = ' '.join(code_token.split())
                    if check_contain_chinese(code_token):
                        continue
                    # code_token = code_token.replace('. ', '.').replace(' .', '.')
                    # code_token = code_token.replace('> >', '>>').replace('< <', '<<')

                    # code_token=code_token.replace("}","} ")
                    # pattern = re.compile(r'}\n}')
                    # code_token = pattern.sub("}} ", code_token)


                    code = js['code']
                    pattern = re.compile(r'//.*\n')
                    code = pattern.sub(" ", code)

                    code = ' '.join(code.split())
                    pattern = re.compile(r'/\*[\s\S]*?\*/')
                    code = pattern.sub(" ", code)

                    code = " ".join(code.split())

                    out1.write(code_token + '\n')
                    out2.write(code + '\n')

            print(file + "  done...")
    out1.close()
    out2.close()

    unique(path + "/go.code_token")
    unique(path+ "/go.src_code")
    print("unique done")




# clean_java()
# clean_csharp()
# unique("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/codes.cs")
# unique("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/code_tokens.java")
# unique("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/codes.java")
# conbine("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/code_tokens.java","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption/codes.cs_filtered")
# split_prefixLM()
# extract_smart_contract()
# splite_data("/mnt/sda/ys/codeT5/CodeT5/data/smartContract/data.jsonl")
# sample_sc_data(10000,10000,500)
# sample_sc_data(5000,5000,500)
# sample_sc_data(1000,1000,100)
# sample_sc_data(500,500,100)
# sample_sc_data(100,100,50)
# sample_sc_data(32,32,32)

# sanity_check("/mnt/sda/ys/codeT5/CodeT5/data/summarize/smartContract/test.jsonl","/mnt/sda/ys/codeT5/CodeT5/data/summarize/smartContract/train.jsonl")

# conbine_twofile("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/transcoder_test.java.detok","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/transcoder_valid.java.detok","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/java.data")
# conbine_twofile("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/transcoder_test.python.detok","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/transcoder_valid.python.detok","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/python.data")
# conbine_twofile("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/transcoder_test.cpp.detok","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/transcoder_valid.cpp.detok","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cpp.data")
#
# clean_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/java.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data")
# clean_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/python.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data")
# clean_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cpp.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data")
#
# sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",32,32)

# clean_codeSearchNet_python("/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/python")
# clean_codeSearchNet_java("/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/java")

# conbine_twofile("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_TransCoderData/java.code_token_filtered","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_TransCoderData/python.code_token_filtered","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_TransCoderData/conbine.data")
# split_prefixLM_files("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_TransCoderData/conbine.data","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_TransCoderData/src.data","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_TransCoderData/tgt.data")

# sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",100,100)
# sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",1000,100)


# sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",16,16)
# sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",8,8)
# sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",500,100)

#leetcode python-go  java-go LMadaption
# clean_codeSearchNet_java("/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/java")
# clean_codeSearchNet_go("/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/go")
# conbine_twofile("/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/java/java.src_code_filtered","/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/go/go.src_code_filtered","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/java-go.conbine.data")
# split_prefixLM_files("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/java-go.conbine.data","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/java-go.src.LMadaption","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/java-go.tgt.LMadaption")
# conbine_twofile("/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/python/python.src_code_filtered","/mnt/sda/ys/codeT5/CodeT5/data/codesearchnet/go/go.src_code_filtered","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/python-go.conbine.data")
# split_prefixLM_files("/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/python-go.conbine.data","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/python-go.src.LMadaption","/mnt/sda/ys/codeT5/CodeT5/data/LMadaption_leetcodedata/python-go.tgt.LMadaption")
#
sample_TransCoder_data("/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanjava.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleanpython.data","/mnt/sda/ys/codeT5/CodeT5/data/translate/transcoderData/cleancpp.data",500,100)
