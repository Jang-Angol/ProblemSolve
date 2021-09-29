"""
재귀를 사용하지 않은 풀이
def permute(nums):
    answer = [[n]for n in nums]
    for i in range(len(nums)-1):
        temp_answer = []
        for l in answer:
            for n in nums:
                temp = l.copy()
                if n not in l:
                    temp.append(n)
                    temp_answer.append(temp)
            #print(temp_answer)
        answer = temp_answer
    return answer
itertools를 사용한 풀이
def permute(nums):
    return list(itertools.permutations(nums))

"""
def dfs(answer,nums,permutation):
    if len(permutation) == len(nums):
        answer.append(permutation)
        return
    for num in nums:
        if num not in permutation:
            perm = permutation.copy()
            perm.append(num)
            dfs(answer,nums,perm)
def permute(nums):
    answer = []
    for num in nums:
        dfs(answer,nums,[num])
    return answer

nums = [1,2,3]
print(permute(nums))