import heapq

def solution(jobs):
    answer = 0
    n = len(jobs)
    heapq.heapify(jobs)
    time = 0
    while jobs:
        job = heapq.heappop(jobs)
        if jobs and job[1] > jobs[0][1]:
            temp_job = heapq.heappop(jobs)
            heapq.heappush(jobs,job)
            job = temp_job
        if time < job[0]:
            time = job[0]
        time += job[1]
        answer += time - job[0]
        print(time-job[0])
        
    return answer // n

jobs = [[0, 3], [1, 9], [2, 6]]
print(solution(jobs))