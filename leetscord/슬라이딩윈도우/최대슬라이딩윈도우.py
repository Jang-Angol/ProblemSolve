from collections import deque

'''
브루트 포스: 49번에서 막힘
def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
    answer = []
    for i in range(0,len(nums)-k+1):
        window = nums[i:i+k]
        maximum = max(window)
        answer.append(maximum)
        #print(window,i,maximum)
    return answer
'''


#큐 사용: 58번에서 막힘
def maxSlidingWindow(nums, k):
        answer = []
        window = deque(nums[0:k])
        maximum = max(window)
        answer.append(maximum)
        for i in range(k,len(nums)):
            temp = window.popleft()
            window.append(nums[i])
            print(window)
            if maximum < nums[i]:
                maximum = nums[i]
            if temp == maximum:
                maximum = max(window)
            answer.append(maximum)
        return answer


nums = [1,3,-1,-3,5,3,6,7]
k = 3

print(maxSlidingWindow(nums,k))