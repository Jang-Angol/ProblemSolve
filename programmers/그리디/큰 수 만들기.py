def solution(number, k):
    answer = []
    
    for i in range(len(number)):
        if not answer:
            answer.append(number[i])
            continue
        if k > 0:
            while answer[-1] < number[i]:
                answer.pop()
                k -= 1
                if not answer or k < 1:
                    break
        answer.append(number[i])            

    return "".join(answer[:len(answer)-k])

number = "1924"
k = 2
print(solution(number,k))