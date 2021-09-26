# Maximum Subarray
from collections import deque

def maxSubArray(nums):
    answer = 0
    dp = nums
    for i in range(len(nums)):
        if nums[i] < 0 and answer > 0:
            dp.append(answer)
            #print(nums[i])
        if answer + nums[i] < 0:
            if len(dp) == 0:
                dp.append(nums[i])
            elif dp[len(dp)-1] <= answer + nums[i]:
                dp.append(answer+nums[i])
                answer = 0
            elif dp[len(dp)-1] > 0: 
                dp.append(answer)
                answer = 0
        else:
            answer += nums[i]
    if answer != 0: dp.append(answer)
    return max(dp)

nums = [-2,1,-3,4,-1,2,1,-5,4]
#nums = [-1,-2]
#nums = [-1,0]
print(maxSubArray(nums))