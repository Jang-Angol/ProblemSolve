"""
# dfs solve 효율성 탈락
def solution(m, n, puddles):
    answer = [0]
    
    def dfs(x,y):
        if x > m or y > n:
            return
        if [x,y] in puddles:
            return
        print(x,y)
        if x == m and y == n:
            answer[0] += 1
            return
        dfs(x+1,y)
        dfs(x,y+1)
    
    dfs(1,1)
    
    return answer[0] % 1000000007
"""
def solution(m, n, puddles):
    answer = [[0 for i in range(m)] for i in range(n)]
    answer[0][0] = 1
    for i in range(n):
        for j in range(m):
            if i == 0 and j == 0:
                continue
            if puddles and [j+1,i+1] in puddles:
                continue
            elif i == 0:
                answer[i][j] = answer[i][j-1]
            elif j == 0:
                answer[i][j] = answer[i-1][j]
            else:
                answer[i][j] = answer[i-1][j] + answer[i][j-1]
    #print(answer)
    return answer[n-1][m-1] % 1000000007

m = 4
n = 3
puddles = [[2,2]]
print(solution(m,n,puddles))