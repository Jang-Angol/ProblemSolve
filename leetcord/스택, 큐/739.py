# 일일 온도
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        
        answer = [0] * n
        stack = []
        
        for i, t in enumerate(temperatures):
            while stack and t > temperatures[stack[-1]]:
                last = stack.pop()
                answer[last] = i - last
            stack.append(i)
            
        return answer