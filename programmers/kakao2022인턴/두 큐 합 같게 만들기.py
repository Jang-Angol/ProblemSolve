def solution(queue1, queue2):
    answer = 0
    make = (sum(queue1) + sum(queue2))/2
    queue = queue1 + queue2
    visited_s = [False] * len(queue)
    visited_e = [False] * len(queue)
    s,e = 0, len(queue1)
    current = sum(queue[s:e])
    while make != current:
        if visited_s[s] and visited_e[e]:
            return -1
        else:
            visited_s[s] = True
            visited_e[e] = True
        if make > current:
            current += queue[e]
            e = (e + 1) % len(queue)
        elif make < current:
            current -= queue[s]
            s = (s + 1) % len(queue)
        if s == e:
            return -1
        answer += 1
    return answer