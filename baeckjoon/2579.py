#계단 오르기(dp)
def solution():
    stairsNum = int(input())
    stairs = []
    points = [0 for i in range(stairsNum)]
    for i in range(stairsNum):
        stairs.append(int(input()))
    points[0] = stairs[0]
    points[1] = stairs[0] + stairs[1]
    if stairsNum > 3:
        points[2] = max(stairs[1] + stairs[2], stairs[0] + stairs[2])
    for i in range(3,stairsNum):
        points[i] = max(points[i-3] + stairs[i-1]+stairs[i], points[i-2] + stairs[i])
    answer = points[stairsNum-1]
    return answer
print(solution())