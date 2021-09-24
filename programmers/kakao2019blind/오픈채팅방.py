record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]

def solution(record):
    answer = []
    # User 닉네임을 저장하기 위한 dictionary
    user = {}
    # User 닉네임을 저장하기 위한 프로세스
    for r in record:
        log = r.split(' ')
        if log[1] not in user:
            user[log[1]] = log[2]
        else:
            if log[0] == "Change":
                user[log[1]] = log[2]
            elif log[0] != "Leave" and user[log[1]] != log[2]:
                user[log[1]] = log[2]
    print(user)
    # record를 정답으로 변환
    for r in record:
        log = r.split(' ')
        if log[0] == "Enter":
            answer.append(user[log[1]]+"님이 들어왔습니다.")
        elif log[0] == "Leave":
            answer.append(user[log[1]]+"님이 나갔습니다.")
    return answer

print(solution(record))