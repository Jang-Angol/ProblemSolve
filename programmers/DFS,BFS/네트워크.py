def dfs(computers,x,visited,n):
    for y in range(n):
        if computers[x][y] == 1 and y not in visited:
            visited.append(y)
            dfs(computers,y,visited,n)
    
def solution(n, computers):
    answer = 0
    visited = []
    for x in range(n):
        if x not in visited:
            visited.append(x)
            dfs(computers,x,visited,n)   
            answer += 1
    return answer