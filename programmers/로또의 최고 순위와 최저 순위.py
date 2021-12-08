def solution(lottos, win_nums):
    answer = [0,0]
    zero = 0
    correct = 0
    for n in lottos:
        if n == 0:
            zero += 1
        elif n in win_nums:
            correct += 1
    answer[0] = 7 - zero - correct
    answer[1] = 7 - correct
    if answer[0] == 7:
        answer[0] = 6
    if answer[1] == 7:
        answer[1] = 6
    return answer