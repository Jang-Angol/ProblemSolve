from collections import deque
# N, M 입력
N, M = map(int,input().split())
# 미로 초기화
maze = []
for i in range(N):
    maze.append(list(map(int,list(input()))))
# 큐, 방문 여부
q = deque([[0,0]])
visited = [[False for j in range(M)] for i in range(N)]
# BFS
while q:
    # 현재 위치
    location = q.popleft()
    for di, dj in zip([-1,1,0,0],[0,0,-1,1]):
        # 이동할 좌표
        i, j = location[0] + di, location[1] + dj
        # 좌표 유효성 검증
        if i < 0 or j < 0 or i >= N or j >= M:
            continue
        # 방문 여부 확인 및 이동 가능 여부 확인
        if not visited[i][j] and maze[i][j] != 0:
            q.append([i,j])
            maze[i][j] = maze[location[0]][location[1]] + 1
            visited[i][j] = True

print(maze[N-1][M-1])
