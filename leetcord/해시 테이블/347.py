# 상위 k 빈도 요소
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        answer = []
        freqs = Counter(nums)
        q = []
        
        for f in freqs:
            heapq.heappush(q,(-freqs[f],f))
        for _ in range(k):
            answer.append(heapq.heappop(q)[1])
        
        return answer