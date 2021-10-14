def solution(brown, yellow):
    answer = []
    width = []
    length = []
    for i in range(2,yellow):
        if yellow % i == 0:
            width.append(yellow//i+2)
            length.append(i+2)
    if not width and not length:
        return [yellow+2,3]
    for w, l in zip(width,length):
        if w * l == brown + yellow:
            return [w,l]
    return answer