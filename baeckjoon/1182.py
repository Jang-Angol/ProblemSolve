# 부분수열의 합
N, S = map(int,input().split())

array = list(map(int,input().split()))

answer = 0

visited = [False] * len(array)

def dfs(sum,idx):
    if idx == N:
        return
    global answer
    sum += array[idx]
    if sum == S:
        answer += 1
    dfs(sum,idx+1)
    dfs(sum-array[idx],idx+1)

dfs(0,0)
print(answer)