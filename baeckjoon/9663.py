# N-Queen

#pypy3 로 사용

N = int(input())

row = [False] * N
s = [False] * (2*N+1)
rs = [False] * (2*N+1)

answer = 0

def dfs(r):
    global answer
    if r == N:
        answer += 1
        return
    #print(r)
    for i in range(N):
        if not row[i] and not s[r+i] and not rs[r-i+N]:
            row[i] = True
            s[r+i] = True
            rs[r-i+N] = True
            dfs(r+1)
            row[i] = False
            s[r+i] = False
            rs[r-i+N] = False

dfs(0)

print(answer)