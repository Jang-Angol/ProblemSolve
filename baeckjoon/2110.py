# 공유기 설치
N, C = map(int,input().split())

homes = []
answer = 0

for _ in range(N):
    homes.append(int(input()))

homes.sort()

low = 1
high = homes[-1] - homes[0]

while low <= high:
    cnt = 1
    mid = (low+high)//2
    prev = homes[0]
    for home in homes:
        if home >= mid + prev:
            cnt += 1
            prev = home
    if cnt >= C:
        low = mid + 1
        answer = mid
    else:
        high = mid - 1

print(answer)