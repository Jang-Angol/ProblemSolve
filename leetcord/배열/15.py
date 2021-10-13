"""
# DFS Time Limit in 299/318
def threeSum(nums):
    answer = []
    def dfs(index,arr):
        if len(arr) == 3:
            arr.sort()
            if sum(arr) == 0 and arr not in answer:
                answer.append(arr)
            return
        for i in range(index,len(nums)):
            dfs(i+1,arr+[nums[i]])
    dfs(0,[])
    return answer
"""
"""
# two pointer Time Limit in 315/318
def threeSum(nums):
    answer = []
    nums.sort()
    #print(nums)
    for i in range(len(nums)):
        left, right = 0, len(nums)-1
        while left < right:
            target = -(nums[left] + nums[right])
            #print(nums[left],target,nums[right])
            #print("left",left,nums[:left]+nums[left+1:right]+nums[right+1:],"right",right)
            if target in nums[:left]+nums[left+1:right]+nums[right+1:]:
                arr = sorted([nums[left],nums[right],target])
                if arr not in answer:
                    answer.append(arr)
            if target >= (nums[left]+nums[right]):
                left += 1
            else:
                right -= 1
    return answer
"""
# 책 풀이
def threeSum(nums):
    answer = []
    nums.sort()
    for i in range(len(nums)):
        # 중복된 값 건너뛰기
        if i > 0 and nums[i] == nums[i-1]:
            continue
        # 간격을 좁혀가며 합 계산
        left, right = i + 1, len(nums) - 1
        while left < right:
            sum = nums[i] + nums[left] + nums[right]
            if sum < 0:
                left += 1
            elif sum > 0:
                right -= 1
            else:
                # sum = 0인 경우이므로 정답 및 스킵 처리
                answer.append([nums[i],nums[left],nums[right]])

                while left<right and nums[left] == nums[left + 1]:
                    left += 1
                while left<right and nums[right] == nums[right - 1]:
                    right -= 1
                left += 1
                right -= 1
    return answer
nums = [-1,0,1,2,-1,-4,-2,-3,3,0,4]
print(threeSum(nums))