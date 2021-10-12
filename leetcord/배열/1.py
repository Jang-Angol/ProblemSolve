def twoSum(nums,target):
    answer = []
    nums_dict = {}
    for i, num in enumerate(nums):
        nums_dict[num] = i
    for i, num in enumerate(nums):
        if target - num in nums_dict and i != nums_dict[target-num]:
            return [i,nums_dict[target-num]]
    return answer

nums = [2,7,11,13]
target = 9
print(twoSum(nums,target))