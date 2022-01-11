# 순회강연
import heapq

N = int(input())

answer = 0

hq = []

for _ in range(N):
    p, d = map(int,input().split())
    heapq.heappush(hq,(-p,d))

day = 0

while hq:
    schedule = heapq.heappop(hq)
    while hq and schedule[1] <= day:
        schedule = heapq.heappop(hq)
    if not hq and schedule[1] <= day:
        break
    answer -= schedule[0]
    day += 1

print(answer)