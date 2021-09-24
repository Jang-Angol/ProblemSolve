from collections import deque

def dfs(numbers, k, target,result,answer_array):
    if k == len(numbers):
        #print(result)
        if result == target:
            answer_array.append(1)
        return 0
    number = numbers[k]
    plus_result = result + number
    minus_result = result - number
    dfs(numbers,k+1,target,plus_result,answer_array)
    dfs(numbers,k+1,target,minus_result,answer_array)

def solution(numbers, target):
    answer = 0
    answer_array = []
    dfs(numbers, 0,target,0,answer_array)
    answer = len(answer_array)
    return answer