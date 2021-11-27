def solution(citations):
    answer = 0
    citations.sort()
    n = len(citations)
    for i, cnt in enumerate(citations):
        h = n - i
        #print(cnt,h,i)
        if h > answer and cnt >= h:
            answer = h
        
    return answer