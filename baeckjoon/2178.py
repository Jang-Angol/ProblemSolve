from collections import deque
# N, M 입력
N, M = map(int,input().split())
# 미로 초기화
maze = []
for i in range(N):
    maze.append(list(map(int,list(input()))))
# 상하좌우
di = [-1,1,0,0]
dj = [0,0,-1,1]
# 큐, 방문 여부
q = deque([[0,0]])
visited = [[False for j in range(M)] for i in range(N)]
# BFS
while q:
    # 현재 위치
    location = q.popleft()
    for i, j in zip(di,dj):
        # 이동할 좌표
        x, y = location[0] + i, location[1] + j
        # 좌표 유효성 검증
        if x < 0 or y < 0 or x >= N or y >= M:
            continue
        # 방문 여부 확인 및 이동 가능 여부 확인
        if not visited[x][y] and maze[x][y] != 0:
            q.append([x,y])
            maze[x][y] = maze[location[0]][location[1]] + 1
            visited[x][y] = True
print(maze[N-1][M-1])
