# 8월 5주차
def solution(word):
    answer = 0
    characters = ["A","E","I","O","U"]
    for x in characters:
        answer += 1
        str = x
        print(str)
        if word == str: return answer
        for y in characters:
            answer += 1
            str = x + y
            print(str)
            if word == str: return answer
            for z in characters:
                answer += 1
                str = x + y + z
                print(str)
                if word == str: return answer
                for v in characters:
                    answer += 1
                    str = x + y + z + v
                    print(str)
                    if word == str: return answer
                    for w in characters:
                        answer += 1
                        str = x + y + z + v + w
                        print(str)
                        if word == str: return answer
    
print(solution("AAAAE"))