def productExceptSelf(nums):
    answer = []
    p = 1
    for num in nums:
        answer.append(p)
        p *= num
    p = 1
    for i in range(len(nums)-1,0-1,-1):
        answer[i] *= p
        p *= nums[i]
    return answer

nums = [-1,1,0,-3,3]
print(productExceptSelf(nums))