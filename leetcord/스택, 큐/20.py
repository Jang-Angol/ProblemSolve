def isValid(s: str) -> bool:
    stack = []
    left = ['(',"[","{"]
    right = [")","]","}"]
    for c in s:
        if c in left:
            stack.append(left.index(c))
        else:
            if not stack:
                return False
            if right.index(c) != stack.pop():
                return False
    if stack:
        return False
    return True