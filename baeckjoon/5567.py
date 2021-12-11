N = int(input())
M = int(input())

friend = {}

for _ in range(M):
    f1, f2 = map(int,input().split())
    if f1 in friend:
        friend[f1].append(f2)
    else:
        friend[f1] = [f2]
    if f2 in friend:
        friend[f2].append(f1)
    else:
        friend[f2] = [f1]

visited = [False for _ in range(N+1)]

#print(friend)

def dfs(f,depth):
    visited[f] = True
    if depth > 2:
        return
    if f in friend:
        for i in friend[f]:
            dfs(i,depth+1)
dfs(1,1)

answer = 0

for _ in visited[2:]:
    if _: answer += 1

print(answer)