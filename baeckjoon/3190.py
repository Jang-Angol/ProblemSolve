# 뱀
from collections import deque

N = int(input())

board = [[0 for _ in range(N)]for i in range(N)]

# 동 남 서 북
dx = [0,1,0,-1]
dy = [1,0,-1,0]

K = int(input())

for i in range(K):
    r, c = map(int,input().split())
    board[r-1][c-1] = 1

L = int(input())

command = deque([])
last_time = 0

for i in range(L):
    X , C = input().split()
    command.append((int(X),C))
    last_time = int(X)

snake=deque([(0,0)])
snake_dir = 0
board[0][0] = -1 

answer = 0

while True:
    if command and command[0][0] == answer:
        if command[0][1] == "D":
            snake_dir += 1
            if snake_dir > 3:
                snake_dir = 0
        else:
            snake_dir -= 1
            if snake_dir < 0:
                snake_dir = 3
        command.popleft()
        ##for _ in range(N):
        ##    print(board[_])
        ##print()
    next_head = (snake[0][0]+dx[snake_dir],snake[0][1]+dy[snake_dir])
    answer += 1
    if 0 <= next_head[0] < N and 0 <= next_head[1] < N:
        if board[next_head[0]][next_head[1]] >= 0:
            snake.appendleft(next_head)
            if board[next_head[0]][next_head[1]] == 0:
                snake_tale = snake.pop()
                board[snake_tale[0]][snake_tale[1]] = 0
            board[next_head[0]][next_head[1]] = -1
        else:
            break
    else:
        break
##for _ in range(N):
##    print(board[_])
##print()    

print(answer)