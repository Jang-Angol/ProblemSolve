import itertools

def dfs(start,n,k,answer, answers):
    if len(answer) == k:
        answers.append(answer)
        return
    for i in range(start+1,n+1):
        l = answer.copy()
        l.append(i)
        print(l)
        dfs(i,n,k,l,answers)

def combine(n, k):
    answers = []
    for i in range(1,n+1):
        dfs(i,n,k,[i],answers)
    return answers
"""
iter tools 사용 책 풀이
def combine(n,k):
    return list(itertools.combinations(range(1,n+1),k))
"""

n = 4
k = 2
print(combine(n,k))