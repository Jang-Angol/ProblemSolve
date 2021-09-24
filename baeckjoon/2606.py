# 바이러스
'''
input
7
6
1 2
2 3
1 5
5 2
5 6
4 7
'''
'''
#BFS
from collections import deque

n = int(input())
v = int(input())
if n > 1:
    computers = [[0]for i in range(n+1)]
    for i in range(v):
        c1, c2 = map(int,input().split(" "))
        computers[c1].append(c2)
    #print(computers)
    if len(computers[1]) != 0:
        queue = deque([1])
        visited = [False]*(n+1)
        answer = 0
        while queue:
            computer = queue.popleft()
            print(computer,end=" ")
            for next_computer in computers[computer]:
                if next_computer != 0:
                    queue.append(next_computer)
                    visited[next_computer] = True
        for visit in visited:
            if visit == True:
                answer += 1
        print(answer)
    else:
        print(0)
else:
    print(0)
'''
n = int(input())
v = int(input())
answer = 0
if n > 1:
    computers = [[]for i in range(n+1)]
    for i in range(v):
        c1, c2 = map(int,input().split(" "))
        computers[c1].append(c2)
    stack = [computers[1]]
    visited = []
    while stack:
        cur = stack.pop()
        for i in cur:
            if i not in visited:
                stack.append(computers[i])
                visited.append(i)
                break
    print(answer,visited)
else:
    print(0)