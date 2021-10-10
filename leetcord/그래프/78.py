"""
속도가 많이 느림
def dfs(nums,arr,answer):
    nums = [n for n in nums if n not in arr]
    for n in nums:
        if n not in arr:
            temp_arr = arr.copy()
            temp_arr.append(n)
            temp_arr.sort()
            if temp_arr not in answer:
                answer.append(temp_arr)
            dfs(nums,temp_arr,answer)
"""

def subsets(nums):
    answer = []
    def dfs(index,arr):
        answer.append(arr)
        for i in range(index,len(nums)):
            dfs(i+1,arr + [nums[i]])
    dfs(0,[])
    return answer

nums = [1,2,3,4,5,6,7,8,9,0]
print(subsets(nums))