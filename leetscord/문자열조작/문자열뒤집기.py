class Solution:
    def reverseString(self, s) -> None:
        for i in range(len(s)//2):
            s[i], s[len(s)-i-1] = s[len(s)-i-1], s[i]

s = ["h","e","l","l","o"]

print(Solution.reverseString(Solution,s), s)