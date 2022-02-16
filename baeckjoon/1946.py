# 신입사원
from collections import deque

T = int(input())

for _ in range(T):
    N = int(input())

    answer = 0
    dList = []
    mList = []
    grade = []
    checked = [False] * N

    for i in range(N):
        d, m = map(int,input().split())
        dList.append((d,i))
        mList.append((m,i))
        grade.append((d,m))
    
    dList.sort()
    mList.sort()

    dList = deque(dList)
    mList = deque(mList)

    while dList and mList:
        if dList:
            d, index = dList.popleft()
            if not checked[index]:
                checked[index] = True
                answer += 1
        if mList:
            m, index = mList.popleft()
            if not checked[index]:
                checked[index] = True
                answer += 1
    print(answer)