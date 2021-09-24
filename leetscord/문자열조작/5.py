# 5. Longest Palindromic Substring
def longestPalindrome(s: str) -> str:
    answer = ""
    if len(s) == 1:
        return s
    for i in range(len(s)):
        if len(answer) > len(s[i:]):
            return answer
        for j in range(len(s),i,-1):
            if len(answer) > len(s[i:j]):
                break
            if(isPalindrome(s[i:j])):
                if len(answer) < len(s[i:j]):
                    answer = s[i:j]
    
    return answer
def isPalindrome(s: str) -> bool:
    if len(s) <= 1:
        return True
    else:
        if s[0] != s[len(s)-1]:
            return False
        if len(s) >= 4:
            odd = len(s)%2
            if odd:
                if s[len(s)//2-1] != s[len(s)//2+1]:
                    return False
            else:
                if s[len(s)//2-1] != s[len(s)//2]:
                    return False
        if s != s[::-1]:
            return False
        else:
            print(len(s))
            return True

#s = "klvxwqyzugrdoaccdafdfrvxiowkcuedfhoixzipxrkzbvpusslsgfjocvidnpsnkqdfnnzzawzsslwnvvjyoignsfbxkgrokzyusxikxumrxlzzrnbtrixxfioormoyyejashrowjqqzifacecvoruwkuessttlexvdptuvodoavsjaepvrfvbdhumtuvxufzzyowiswokioyjtzzmevttheeyjqcldllxvjraeyflthntsmipaoyjixygbtbvbnnrmlwwkeikhnnmlfspjgmcxwbjyhomfjdcnogqjviggklplpznfwjydkxzjkoskvqvnxfzdrsmooyciwulvtlmvnjbbmffureoilszlonibbcwfsjzguxqrjwypwrskhrttvnqoqisdfuifqnabzbvyzgbxfvmcomneykfmycevnrcsyqclamfxskmsxreptpxqxqidvjbuduktnwwoztvkuebfdigmjqfuolqzvjincchlmbrxpqgguwuyhrdtwqkdlqidlxzqktgzktihvlwsbysjeykiwokyqaskjjngovbagspyspeghutyoeahhgynzsyaszlirmlekpboywqdliumihwnsnwjc"
#s = "tattarrattat"
s = "abb"
print(len(s),len(s)//2)
print(longestPalindrome(s))