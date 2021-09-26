from collections import deque

def letterCombinations(digits):
    answer = []
    keys = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
    digits = deque(digits)
    while digits:
        n = int(digits.popleft())
        temp_answer = []
        if not answer:
            for key in list(keys[n]):
                temp_answer.append(key)
        else:
            for word in answer:
                for key in list(keys[n]):
                    temp_answer.append(word+key)
        answer = temp_answer
    return answer
digits = "23"
print(letterCombinations(digits))