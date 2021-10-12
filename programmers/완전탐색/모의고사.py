def solution(answers):
    answer = []
    grades = [0,0,0]
    n = len(answers)
    # 1번 1,2,3,4,5
    student1 = [1,2,3,4,5] * (n//5 + 1)
    # 2번 2,1,2,3,2,4,2,5
    student2 = [2,1,2,3,2,4,2,5] * (n//8 + 1)
    # 3번 3,3,1,1,2,2,4,4,5,5
    student3 = [3,3,1,1,2,2,4,4,5,5] * (n//10 + 1)
    for i in range(n):
        if student1[i] == answers[i]:
            grades[0] += 1
        if student2[i] == answers[i]:
            grades[1] += 1
        if student3[i] == answers[i]:
            grades[2] += 1
    max_grade = max(grades)
    for i in range(3):
        if grades[i] == max_grade:
            answer.append(i+1)
    return answer