# 중복 문자 없는 가장 긴 부분 문자열
from collections import deque

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) < 2:
            return len(s)
        answer = 1
        count = 1
        left = 0
        right = 1
        d = {s[left]:0}
        sub_s = deque([s[left]])
        while right < len(s) and left < right:
            if s[right] not in sub_s:
                sub_s.append(s[right])
                d[s[right]] = right
            elif s[left] == s[right]:
                sub_s.popleft()
                sub_s.append(s[right])
                d[s[right]] = right
                left += 1
            else:
                answer = max(len(sub_s),answer)
                p_left = left
                left = d[s[right]]
                delete = left - p_left
                for _ in range(delete+1):
                    sub_s.popleft()
                sub_s.append(s[right])
                d[s[right]] = right
                left += 1
            right += 1
            
        return max(len(sub_s),answer)

s = "utyodfcyzmyufyhp"
print(Solution.lengthOfLongestSubstring(Solution,s))