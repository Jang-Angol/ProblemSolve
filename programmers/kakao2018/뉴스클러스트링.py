# Counter

def join(s1,s2):
    joinSet = []
    a = s1.copy()
    b = s2.copy()
    for s in a:
        if s in b:
            b.remove(s)
            joinSet.append(s)
    #print(joinSet)
    return len(joinSet)

def union(s1,s2):
    unionSet = s2.copy()
    a = s1.copy()
    b = s2.copy()
    for s in a:
        if s not in b:
            unionSet.append(s)
        else:
            b.remove(s)
    #print(unionSet)
    return len(unionSet)
        

def solution(str1, str2):
    answer = 0
    str1 = list(str1.lower())
    s1 = []
    for i in range(0,len(str1)):
        if i != len(str1)-1 and str1[i].isalpha() and str1[i+1].isalpha():
            s1.append(str1[i]+str1[i+1])
    str2 = list(str2.lower())
    s2 = []
    for i in range(0,len(str2)):
        if i != (len(str2)-1) and str2[i].isalpha() and str2[i+1].isalpha():
            s2.append(str2[i]+str2[i+1])
    if len(s1) == 0 and len(s2) == 0: return 65536
    else:
        answer = int(join(s1,s2) / union(s1,s2) * 65536)
    #print(s1,s2)
    return answer

str1 = "FRANCE"
str2 = "french"
print(solution(str1,str2))