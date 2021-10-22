from collections import deque

def solution(people, limit):
    answer = 0
    
    people = deque(sorted(people))
    
    #print(people)
    
    while people:
        boat = people.pop()
        while people and boat + people[0] <= limit:
            boat += people.popleft()
        answer += 1
    
    return answer