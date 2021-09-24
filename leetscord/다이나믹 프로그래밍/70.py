# Climbing Stairs
def climbStairs(n):
    answer = []
    answer.append(1)
    answer.append(2)
    answer.append(3)
    if n > 3:
        for i in range(3,n):
            answer.append( answer[i-1] + answer[i-2])
    return answer[n-1]

n = 4
print(climbStairs(n))