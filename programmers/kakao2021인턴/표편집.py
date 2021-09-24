def solution(n, k, cmd):
    answer = ''
    row = ["O" for i in range(n)]
    table = [i for i in range(n)]
    current = k
    trash = []
    for command in cmd:
        print("current:",current)
        print(command)
        command = command.split(" ")
        if command[0] == "C":
            row[table[current]] = "X"
            d = table[current]
            del table[current]
            trash.append(d)
            if current == len(table)-1:
                current -= 1
            print(row)
        elif command[0] == "U":
            current -= int(command[1])
        elif command[0] == "D":
            current += int(command[1])
        elif command[0] == "Z":
            print(trash)
            pre = trash.pop()
            row[pre] = "O"
            table.insert(pre,pre)
            print(row)
        print(table)
    for value in row:
        answer += value
    return answer

n = 8
k = 2
cmd = ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]
print(solution(n,k,cmd))