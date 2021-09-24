'''
import collections

def solution(progresses, speeds):
    progresses = collections.deque(progresses)
    speeds = collections.deque(speeds)
    answer = []
    while len(progresses):
        complete = collections.deque([])
        for i in range(0, len(progresses)):
            progresses[i] += speeds[i]
        while len(progresses) and progresses[0] >= 100:
            complete.append(1)
            progresses.popleft()
            speeds.popleft()
        if len(complete):
            answer.append(len(complete))
 
    return answer
'''
from collections import deque

def solution(progresses, speeds):
    answer = []
    progresses = deque(progresses)
    speeds = deque(speeds)
    while progresses:
        complete = 0
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        while progresses and progresses[0] >= 100:
            progresses.popleft()
            speeds.popleft()
            complete += 1
        if complete > 0 : answer.append(complete)
        print(progresses)
            
    return answer

progresses = [93, 30, 55]
speeds = [1, 30, 5]

print(solution(progresses,speeds))