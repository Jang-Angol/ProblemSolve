#부분 문자열이 포함된 최소 윈도우
from collections import deque, Counter
'''
큐로 풀이 264번에서 막힘
def join(s1,s2):
    joinSet = []
    a = s1.copy()
    b = s2.copy()
    for s in a:
        if s in b:
            b.remove(s)
            joinSet.append(s)
    #print(joinSet)
    joinSet.sort()
    return joinSet

def minWindow(s,t):
    answer = ""
    window = deque([])
    temp_t = deque([])
    list_t = sorted(list(t))
    for c in s:
        window.append(c)
        if c in t:
            temp_t.append(c)
        while join(list(t),list(temp_t)) == list_t:
            if len(window) < len(answer) or answer == "":
                answer = "".join(window)
                #print(answer)
            a = window.popleft()
            if a in temp_t:
                temp_t.popleft()
            print(window)
        print(join(list(t),list(temp_t)),list_t)
        print(window)
    return answer
'''
# 교재 풀이
def minWindow(s,t):
    need = Counter(t)
    missing = len(t)
    left = start = end = 0
    for right, c in enumerate(s,1):
        missing -= need[c] > 0
        need[c] -= 1
        if missing == 0:
            while left<right and need[s[left]] < 0:
                need[s[left]] += 1
                left += 1
            if not end or right - left <= end - start:
                start, end = left, right
            need[s[left]]+=1
            missing += 1
            left+=1
        print(need,left,right)
    return s[start:end]
s = "ADOBECODEBANC"
t = "ABC"
print(minWindow(s,t))