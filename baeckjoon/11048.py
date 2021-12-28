# 이동하기

N, M = map(int,input().split())

maze = []

for i in range(N):
    maze.append(list(map(int,input().split())))

for r in range(N):
    for c in range(M):
        max_value = 0
        for i, j in zip([0,-1,-1],[-1,0,-1]):
            if r + i < 0 or c + j < 0:
                continue
            if max_value < maze[r+i][c+j]:
                max_value = maze[r+i][c+j]
        maze[r][c] += max_value
print(maze)
print(maze[N-1][M-1])