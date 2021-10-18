from collections import deque

def solution(n, lost, reserve):
    answer = n - len(lost)
    lost.sort(reverse=True)
    reserve.sort(reverse=True)
    
    for r_num in reserve:
        if r_num in lost:
            lost.remove(r_num)
            reserve.remove(r_num)
            answer += 1
            continue
    
    lost = deque(lost)
    reserve = deque(reserve)
    
    while reserve:
        s_num = reserve.popleft()
        for i in lost:
            if abs(i-s_num) < 2:
                answer += 1
                lost.remove(i)
                break
    
    return answer