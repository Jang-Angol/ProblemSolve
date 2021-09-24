from collections import deque

priorities = [1, 1, 9, 1, 1, 1]
location = 0

def solution(priorities, location):
    answer = 0
    # 우선순위 대기열
    queue = deque(priorities)
    # 문서 위치 대기열
    indexqueue = deque([i for i in range(len(priorities))])
    # 출력된 문서 순서
    indexstack = []
    while queue:
        # 출력하려면 1 자리를 바꿧으면 0
        p = 1
        document = queue.popleft()
        index = indexqueue.popleft()
        for i in list(queue):
            if i > document:
                queue.append(document)
                indexqueue.append(index)
                p = 0
                break
        if (p): indexstack.append(index)
    print(indexstack)
    return indexstack.index(location) + 1

print(solution(priorities,location))