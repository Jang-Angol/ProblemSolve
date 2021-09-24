import re
'''
재귀 Time Out
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub('[\,\-\=\.\#\/\?\:\$\}]', '', s)
        s = s.replace(" ","")
        s = s.lower()
        print(s, len(s))
        if len(s) <= 1:
            return True
        elif s[0] != s[len(s)-1]:
            print(False)
            return False
        return Solution.isPalindrome(self,s[1:-1])
'''
import re
class Solution:
    def isPalindrome(self, s: str):
        s = s.replace(" ","")
        s = s.lower()
        s = re.sub('[^a-z0-9]', '', s)
        if len(s) <= 1:
            return True
        else:
            if s != s[::-1]:
                return False
            else:
                return True

s = "A man, a plan, a canal: Panama"

print(Solution.isPalindrome(Solution,s))