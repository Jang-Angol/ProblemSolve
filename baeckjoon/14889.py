# 스타트와 링크
from itertools import combinations

N = int(input())

status = []
answer = []

for i in range(N):
    status.append(list(map(int,input().split())))

visited = [False] * N
visited[0] = True

def dfs(v,idx):
    if v == N//2:
        team_1_score = 0
        team_2_score = 0
        for i in range(N):
            for j in range(i+1,N):
                if visited[i] and visited[j]:
                    team_1_score += status[i][j]
                    team_1_score += status[j][i]
                elif not visited[i] and not visited[j]:
                    team_2_score += status[i][j]
                    team_2_score += status[j][i]
        answer.append(abs(team_2_score-team_1_score))
        return
    for i in range(idx+1,N):
        visited[i] = True
        dfs(v+1,i)
        visited[i] = False
dfs(1,0)
print(min(answer))