import math

def isPrimaryNumber(n):
    if n < 2:
        return False
    for i in range(2,int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    permute = []
    numbers = list(numbers)
    def dfs(permutation, t_numbers):
        if permutation != "":
            if int(permutation) not in permute:
                permute.append(int(permutation))
        for number in t_numbers:
            next_numbers = t_numbers[:]
            next_numbers.remove(number)
            dfs(permutation + number, next_numbers)
    dfs("",numbers[:])
    for n in permute:
        if isPrimaryNumber(n):
            answer += 1         
    return answer

numbers = "011"
print(solution(numbers))