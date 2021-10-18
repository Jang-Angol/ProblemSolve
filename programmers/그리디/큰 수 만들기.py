def solution(number, k):
    answer = ''
    used = [True] * len(number)
    print(used)
    for n in range(10):
        if k == 0:
            break
        for i in range(len(number)):
            print(i)
            if k == 0:
                break
            if used[i] and number[i] == str(n):
                used[i] = False
                k -= 1
    for i in range(len(number)):
        if used[i]:
            answer += number[i]
    
    return answer

number = "1924"
k = 2
print(solution(number,k))