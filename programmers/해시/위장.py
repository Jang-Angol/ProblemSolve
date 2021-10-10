def solution(clothes):
    answer = 0

    closet = dict()
    cur_closet = 0
    case = 1

    for i in clothes:
        if i[1] in closet:
            closet[i[1]] += 1
            cur_closet += 1
        else:
            closet[i[1]] = 1
            cur_closet += 1

    if len(closet) == 1:
        answer = cur_closet
    else:
        for i in closet:
            case *= closet[i] + 1
        answer = case - 1
    
    #print(closet, len(closet), cur_closet)

    return answer