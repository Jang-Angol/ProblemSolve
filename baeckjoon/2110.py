# 공유기 설치
N, C = map(int,input().split())

homes = []

for _ in range(N):
    homes.append(int(input()))

homes.sort()

print(homes)

def binary_search(s,e,v):
    mid = (s+e)//2
    while homes[mid] != v:
        print(homes[mid])
        if (e-s) < 2:
            return mid
        if homes[mid] > v:
            e = mid -1
        elif homes[mid] == v:
            return mid
        else:
            s = mid + 1
        mid = (s+e)//2
v = binary_search(0,len(homes),(homes[0]+homes[-1])//2)

print(v)