def solution(s):
    answer = []
    num = {'zero':'0','one':'1','two':'2','three':'3','four':'4','five':'5','six':'6','seven':'7','eight':'8','nine':'9'}
    word = []
    for c in s:
        if c not in ['0','1','2','3','4','5','6','7','8','9']:
            word.append(c)
        else:
            answer.append(str(c))
        if word and "".join(word) in num:
            answer.append(num["".join(word)])
            word = []
        
        print(word)
    print(answer)
    number = "".join(answer)
    return int(number)

s = "one4seveneight"
print(solution(s))