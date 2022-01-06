# 저울
"""
스터디 풀이 -> DP
"""
N = int(input())

weights = list(map(int,input().split()))
weights.sort()

able_weights = [0]
answer = 1

b = False
for i in range(N):
    leng = len(able_weights)
    for j in range(leng):
        if able_weights[j] + weights[i] > answer:
            print(answer)
            b = True
            break
        elif able_weights[j] + weights[i] == answer:
            able_weights.append(able_weights[j]+weights[i])
            answer += 1
    if b:
        break
#print(able_weights)
if not b:
    print(answer)
"""
블로그풀이 -> 그리디
N = int(input())

weights = list(map(int,input().split()))
weights.sort()

answer = 1
for i in range(N):
    if answer < i:
        break
    answer += weights[i]
print(answer)
"""