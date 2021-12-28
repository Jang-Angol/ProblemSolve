# 안전 영역
import sys
sys.setrecursionlimit(10**6)

N = int(input())

mp = []

max_height = 0

max_area = 0

for i in range(N):
    array = list(map(int,input().split()))
    max_height = max(max_height,max(array))
    mp.append(array)
for h in range(0,max_height):
    temp_mp = [line[:] for line in mp]
    area_num = 0
    def dfs(x,y):
        if x < 0 or y < 0 or x >= N or y >= N:
            return
        if temp_mp[x][y] > h:
            temp_mp[x][y] = 0
            for i, j in zip([-1,1,0,0],[0,0,1,-1]):
                dfs(x+i,y+j)
        else:
            return
    for x in range(N):
        for y in range(N):
            if temp_mp[x][y] > h:
                dfs(x,y)
                area_num += 1
    if area_num > max_area:
        max_area = area_num
print(max_area)