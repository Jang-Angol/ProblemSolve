def solution(price, money, count):
    answer = 0
    cnt = 1
    while count:
        money -= price*cnt
        cnt += 1
        count -= 1
    if money < 0: answer = -1*money

    return answer