def solution(triangle):
    answer = 0
    sum = []
    for f, layer in enumerate(triangle):
        if not sum:
            sum.append(layer)
            continue
        sum_layer = []
        for i in range(f+1):
            if i-1 < 0:
                sum_layer.append(layer[i]+sum[f-1][i])
            elif i == f:
                sum_layer.append(layer[i]+sum[f-1][i-1])
            else:
                left_value = layer[i] + sum[f-1][i-1]
                right_value = layer[i] + sum[f-1][i]
                sum_layer.append(max(left_value,right_value))
        sum.append(sum_layer)
    answer = max(sum[len(sum)-1])
    return answer

triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
print(solution(triangle))