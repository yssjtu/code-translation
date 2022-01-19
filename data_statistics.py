java = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/test.java-cs.txt.java"
cs = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/test.java-cs.txt.cs"

Transcoderjava = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/cleanjava.data.test"
Transcoderpython = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/cleanpython.data.test"

LeetcodeJava1 = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/test.java-go.txt.java"
LeetcodeGo1 = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/test.java-go.txt.go"

LeetcodePython = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/test.python-go.txt.python"
LeetcodeGo2 = "/mnt/sda/ys/codeT5/CodeT5/data_sample_8/translate/test.python-go.txt.go"

def cal_avg_ngrams(file,name):
    sources = [
        x for x in open(file, 'r', encoding='utf-8').readlines()]

    ngram=0
    for line in sources:
        ngram+=len(line.strip().split())
    avg_ngram=ngram/len(sources)
    print(name + " : "+str(avg_ngram))

def cal_avg_ngrams_threshold(file, name,thresh):
    sources = [
        x for x in open(file, 'r', encoding='utf-8').readlines()]

    ngram = 0
    for line in sources:
        if(len(line.strip().split())<=thresh):
            ngram += 1
    avg_ngram = ngram / len(sources)
    print(name + " : " + str(avg_ngram))


def cal_avg_ngrams_2(file1,file2, name):
    sources1 = [
        x for x in open(file1, 'r', encoding='utf-8').readlines()]

    sources2 = [
        x for x in open(file2, 'r', encoding='utf-8').readlines()]
    ngram = 0
    for line in sources1:
        ngram += len(line.strip().split())

    for line in sources2:
        ngram += len(line.strip().split())
    avg_ngram = ngram / (len(sources1)+len(sources2))
    print(name + " : " + str(avg_ngram))

cal_avg_ngrams_2(java,cs,"java-cs")
cal_avg_ngrams_2(Transcoderjava,Transcoderpython,"java-python")
cal_avg_ngrams_2(LeetcodeJava1,LeetcodeGo1,"java-Go")
cal_avg_ngrams_2(LeetcodePython,LeetcodeGo2,"python-go")

cal_avg_ngrams(java,"java")
cal_avg_ngrams(cs,"cs")

cal_avg_ngrams(Transcoderjava,"j-p:java")
cal_avg_ngrams(Transcoderpython,"j-p:python")

cal_avg_ngrams(LeetcodeJava1,"j-g:java")
cal_avg_ngrams(LeetcodeGo1,"j-g:go")

cal_avg_ngrams(LeetcodePython,"p-g:ptyhon")
cal_avg_ngrams(LeetcodeGo2,"p-g:go")

cal_avg_ngrams_threshold(java,"java",5)
cal_avg_ngrams_threshold(cs,"cs",5)