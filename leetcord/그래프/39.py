from collections import deque

answers = []

def dfs(candidates,answer,target):
    print(answer)
    if sum(answer) > target:
        return
    if sum(answer) == target:
        answers.append(answer)
        return
    candidates = deque(candidates)
    while candidates:
        l = answer.copy()
        l.append(candidates[0])
        dfs(candidates,l,target)
        i = candidates.popleft()

def combinationSum(candidates,target):
    candidates.sort()
    dfs(candidates,[],target)
    return answers

candidates = [2,3,5]
target = 8
print(combinationSum(candidates,target))