# DFS와 BFS
from collections import deque
def DFS(n,graph,visited):
    if not visited[n]: print(n,end=" ")
    visited[n] = True
    graph[n].sort()
    for i in graph[n]:
        if visited[i] == False:
            DFS(i,graph,visited)
def BFS(n,graph):
    queue = deque()
    queue.append(n)
    visited = [False for i in range(N+1)]
    visited[0] = True
    while queue:
        n = queue.popleft()
        if not visited[n]: print(n,end=" ")
        visited[n] = True
        graph[n].sort()
        for i in graph[n]:
            if visited[i] == False:
                queue.append(i)
N, M , V = map(int,input().split(" "))
graph = [[0 for j in range(N+1)] for i in range(N+1)]
visited = [False for i in range(N+1)]
visited[0] = True
for i in range(M):
    vertax = input().split(" ")
    graph[int(vertax[0])].append(int(vertax[1]))
    graph[int(vertax[1])].append(int(vertax[0]))
DFS(V,graph,visited)
print()
BFS(V,graph)
print()