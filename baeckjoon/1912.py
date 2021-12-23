# 연속합
n = int(input())

array = list(map(int,input().split()))

answer = [0]*len(array)
answer[0] = array[0]

for i in range(1,len(array)):
    answer[i] = max(array[i],answer[i-1]+array[i])


print(max(answer))