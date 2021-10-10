from collections import deque
import heapq

"""
# queue 풀이
def solution(operations):
    answer = [0,0]
    queue = deque([])
    for operation in operations:
        command, value = operation.split(" ")
        if command == "I":
            queue.append(int(value))
            queue = deque(sorted(list(queue)))
        else:
            if len(queue) == 0:
                continue
            if value == "1":
                queue.pop()
            else:
                queue.popleft()
    if queue:
        answer = [max(queue),min(queue)]
    return answer
"""
# 이중 heap 
def solution(operations):
    answer = [0,0]
    queue = []
    for operation in operations:
        command, value = operation.split(" ")
        if command == "I":
            heapq.heappush(queue,int(value))
        else:
            if len(queue) == 0:
                continue
            if value == "1":
                queue = heapq.nlargest(len(queue),queue)[1:]
                heapq.heapify(queue)
            else:
                heapq.heappop(queue)
    if queue:
        answer = [heapq.nlargest(1,queue)[0],heapq.heappop(queue)]
    
    return answer