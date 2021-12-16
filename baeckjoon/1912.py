# 연속합
n = int(input())

array = list(map(int,input().split()))

start , end = 0, len(array) - 1

answer = [sum(array)]*len(array)

while start < end:
    if array[start] < array[end]:
        start += 1
        if start < len(array) and answer[start] < answer[start-1] - array[start-1]:
            answer[start] = answer[start-1] - array[start-1]
    else:
        end -= 1
        if 0 < end and answer[end] < answer[end+1] - array[end+1]:
            answer[end] = answer[end+1] - array[end+1]
    print(array[start:end+1])
    print(answer)
print(max(answer))