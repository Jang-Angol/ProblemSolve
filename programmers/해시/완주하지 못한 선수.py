def solution(participant, completion):

    member = dict()

    for i in participant:
        if i in member:
            member[i] +=1
        else:
            member[i] = 1
    
    for i in completion:
        if member[i] == 1:
            del member[i]
        else:
            member[i] -=1

    return list(member.keys())[0]