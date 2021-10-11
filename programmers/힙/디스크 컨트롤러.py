from collections import deque
import heapq

def solution(jobs):
    answer = 0
    n = len(jobs)
    jobs = deque(sorted(jobs))
    time = 0
    pQ = []
    while jobs or pQ:
        if not pQ:
            process = jobs.popleft()
            heapq.heappush(pQ,process[::-1])
        while jobs and time >= jobs[0][0]:
            process = jobs.popleft()
            heapq.heappush(pQ,process[::-1])
        process = heapq.heappop(pQ)
        if time < process[1]:
            time = process[1]
        time = time + process[0]
        answer += time - process[1]
        
    return answer//n

jobs = [[0, 3], [1, 9], [2, 6]]
print(solution(jobs))