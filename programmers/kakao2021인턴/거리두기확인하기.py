def checkDistance(x,y, room):
    # 상하좌우 2칸
    for step in [[-2,0],[2,0],[0,-2],[0,2]]:
        if x+step[0] < 0 or y+step[1] < 0 or x+step[0] > 4 or y+step[1] > 4:
            continue
        else:
            # 응시자 사이에 파티션이 없는 경우
            if room[x+step[0]][y+step[1]] == "P" and room[x+step[0]//2][y+step[1]//2] != "X":
                return 1
    # 상하좌우 대각선 1칸
    for i in range(-1,2):
        for j in range(-1,2):
            if x + i < 0 or y + j < 0 or x + i > 4 or y + j > 4:
                continue
            # 원점
            elif i == 0 and j == 0:
                continue
            # 상하좌우 1칸
            elif abs(i) + abs(j) < 2 and room[x+i][y+j] == "P":
                return 1
            # 대각선 1칸
            elif abs(i) + abs(j) == 2 and room[x+i][y+j] == "P":
                if room[x][y+j] != "X" or room[x+i][y] != "X":
                    return 1
    return 0

def roomCheck(room):
    for i in range(5):
        for j in range(5):
            if room[i][j] == "P":
                if checkDistance(i,j,room):
                    return 0
    return 1

def solution(places):
    answer = []
    for room in places:
        answer.append(roomCheck(room))
    return answer

places = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
print(solution(places))