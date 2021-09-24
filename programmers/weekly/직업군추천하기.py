def solution(table, languages, preference):
    answer = ''
    grade = {}
    job_grade = {"SI":0,"CONTENTS":0,"HARDWARE":0,"PORTAL":0,"GAME":0}
    for category in table:
        category = category.split(" ")
        grade[category[0]] = [category[1],category[2],category[3],category[4],category[5]]
    max_grade = 0
    for language, point in zip(languages,preference):
        for category in ["SI","CONTENTS","HARDWARE","PORTAL","GAME"]:
            if language in grade[category]:
                job_grade[category] += (5 - grade[category].index(language)) * point
    job_grade = dict(sorted(job_grade.items()))
    answer = max(job_grade,key=job_grade.get)
    return answer
    
table = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
languages = ["PYTHON", "C++", "SQL"]
preference = [7, 5, 5]

print(solution(table,languages,preference))