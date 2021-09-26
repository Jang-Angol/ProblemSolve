# Reorder Data in Log Files
def reorderLogFiles(logs):
    letterLogs = []
    digitLogs = []
    reorderLogs = []
    for log in logs:
        log = log.split(" ")
        if log[1].isalpha(): letterLogs.append([log[0]," ".join(log[1:])])
        else: digitLogs.append(" ".join(log))
    letterLogs.sort(key=lambda x: (x[1],x[0]))
    for log in letterLogs:
        reorderLogs.append(log[0]+" "+log[1])
    reorderLogs += digitLogs
    return reorderLogs

logs = ["27 85717 7", "2 y xyr fc", "52 314 99", "d 046099 0", "m azv x f", "7e apw c y", "8 hyyq z p", "6 3272401", "c otdk cl", "8 ksif m u"]

print(reorderLogFiles(logs))