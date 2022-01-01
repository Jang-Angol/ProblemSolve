# 트리의 부모 찾기
from collections import deque

N = int(input())

graph = [[] for i in range(N)]
visited = [False]*N
p_node = [0] * N

for i in range(N-1):
    v1 , v2 = map(int,input().split())
    graph[v1-1].append(v2-1)
    graph[v2-1].append(v1-1) 

q = deque([0])

while q:
    node = q.popleft()
    visited[node] = True
    for c in graph[node]:
        if not visited[c]:
            q.append(c)
            p_node[c] = node
        
for i in range(1,N):
    print(p_node[i]+1)