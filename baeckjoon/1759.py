# 암호 만들기
from itertools import combinations

N, C = map(int,input().split())

alphabets = list(input().split())

alphabets.sort()

words = list(combinations(alphabets,N))

for word in words:
    word = list(word)
    word.sort()
    vowels = 0
    consonants = 0
    for c in word:
        if c in ['a','e','i','o','u']:
            vowels += 1
        else:
            consonants += 1
    if vowels >= 1 and consonants >= 2:
        print("".join(word))
