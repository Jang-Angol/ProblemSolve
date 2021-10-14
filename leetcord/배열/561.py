def arrayPairSum(nums):
    answer = 0
    nums.sort()
    for i in range(0,len(nums),2):
        answer += nums[i]
    return answer

nums = [6,2,6,5,1,2]
print(arrayPairSum(nums))