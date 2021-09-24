# Summer/Winter Coding(2019) 멀쩡한 사각형
def solution(w,h):
    answer = 0
    if w == h:
        return w*h - w
    elif w == 1 or h == 1:
        return answer
    else:
        for i in range(w):
        #print(int(tilt*i))
            answer += h*i//w
        return answer * 2

w = 8
h = 12
print(solution(w,h))