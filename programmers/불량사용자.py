def checkID(u_id,b_id):
    if len(u_id) != len(b_id):
        return False
    for u,b in zip(u_id,b_id):
        if b == '*':
            continue
        if u != b:
            return False
    return True
def solution(user_id, banned_id):
    visited = [False] * len(user_id)
    check = [] # 중복값이 없게
    def dfs(depth,store):
        if depth == len(banned_id):
            a = sorted(store)
            if a not in check:
                check.append(a)
            return
        for i in range(len(user_id)):
            if len(user_id[i]) != len(banned_id[depth]):
                continue
            if checkID(user_id[i],banned_id[depth]) and not visited[i]:
                visited[i] = True
                store.append(user_id[i])
                dfs(depth+1,store)
                visited[i] = False
                store.pop()
    dfs(0,[])
    return len(check)

user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id = ["fr*d*", "abc1**"]

print(solution(user_id,banned_id))