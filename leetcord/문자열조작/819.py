import re
# 819. Most Common Word
def mostCommonWord(paragraph,banned):
    paragraph = paragraph.lower()
    paragraph = re.sub('[^a-z0-9\s]', ' ', paragraph)
    words = paragraph.split(' ')
    print(words)
    wordDic = {}
    for word in words:
        if word in banned or word == "":
            continue
        if word not in wordDic:
            wordDic[word] = 1
        else:
            wordDic[word] += 1
    return max(wordDic,key=(lambda k: wordDic[k]))

paragraph = "a, a, a, a, b,b,b,c, c"
banned = ["a"]

print(mostCommonWord(paragraph,banned))