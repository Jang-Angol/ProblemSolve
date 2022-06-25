class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        q = []
        answer = 0
        for n in nums:
            heapq.heappush(q,(-n,n))
        for _ in range(k):
            answer = heapq.heappop(q)[1]
        return answer