# 두 수의 합
N = int(input())

numbers = list(map(int,input().split()))

X = int(input())

answer = 0

numbers.sort()

start, end = 0, len(numbers) - 1

while end > start:
    if numbers[start] + numbers[end] < X:
        start += 1
    elif numbers[start] + numbers[end] == X:
        #print(numbers[start],numbers[end])
        end -= 1
        answer += 1
    else:
        end -= 1
    

print(answer)