# 뱀
from collections import deque

N = int(input())

board = [[0 for _ in range(N)]for i in range(N)]

# 동 남 서 북
dx = [0,1,-1,0]
dy = [1,0,0,-1]

K = int(input())

for i in range(K):
    r,c = map(int,input().split()),
    board[r-1][c-1] = 1

L = int(input())

for i in range(L):
    command = list(input().split())
    

snake=deque([(0,0)])

