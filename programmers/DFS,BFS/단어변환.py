from collections import Counter

def checkChange(begin,word):
    c_begin = Counter(begin)
    c_word = Counter(word)
    union_c = c_begin|c_word
    join_c = c_begin&c_word
    rest_c = union_c - join_c
    if sum(rest_c.values()) == 2:
        return True
    else:
        return False

def dfs(begin,words,target,visited,step,steps):
    step += 1
    for word in words:
        if word == target and checkChange(begin,word):
            steps.append(step+1)
            break
        if word not in visited and checkChange(begin,word):
            visited.append(word)
            dfs(word,words,target,visited,step,steps)

def solution(begin, target, words):
    answer = 0
    steps = []
    for word in words:
        step = 0
        visited = []
        if word == target and checkChange(begin,word):
            steps.append(1) 
            continue
        if word not in visited:
            if checkChange(begin,word):
                visited.append(word)
                dfs(word,words,target,visited,step,steps)
    if steps:
        answer = min(steps)
    return answer

begin = "hit"
target = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]
