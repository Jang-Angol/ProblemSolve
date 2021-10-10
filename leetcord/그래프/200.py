def find(grid, x, y):
    if x < 0 or y < 0 or x > len(grid) - 1 or y > len(grid[0]) - 1:
        return
    if grid[x][y] != "1":
        return
    grid[x][y] = "3"
    for a,b in zip([-1,1,0,0],[0,0,-1,1]):
        find(grid,x+a,y+b)

def numIslands(grid):
    answer = 0
    for x in range(len(grid)):
        for y in range(len(grid[0])):
            if grid[x][y] == "1":
                answer += 1
                find(grid,x,y)
    return answer
grid = [
  ["0","0","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
print(numIslands(grid))
print(grid)