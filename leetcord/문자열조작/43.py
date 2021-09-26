def groupAnagrams(strs):
    anagram = {}
    for s in strs:
        key = "".join(sorted(list(s)))
        if key not in anagram:
            anagram[key] = [s]
        else:
            anagram[key].append(s)
    return list(anagram.values())

strs =  ["eat","tea","tan","ate","nat","bat"]
print(groupAnagrams(strs))