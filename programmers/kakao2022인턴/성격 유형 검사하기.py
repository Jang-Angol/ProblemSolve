def solution(survey, choices):
    answer = ''
    score = {'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    for type, choice in zip(survey,choices):
        character = choice - 4
        if character < 0:
            score[type[0]] -= character
        else:
            score[type[1]] += character
    if score['R'] >= score['T']:
        answer += 'R'
    else:
        answer += 'T'
    if score['C'] >= score['F']:
        answer += 'C'
    else:
        answer += 'F'
    if score['J'] >= score['M']:
        answer += 'J'
    else:
        answer += 'M'
    if score['A'] >= score['N']:
        answer += 'A'
    else:
        answer += 'N'
    return answer