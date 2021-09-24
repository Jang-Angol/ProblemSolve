class boxer:
    def __init__(self,number,weights,win_rate,heavy_win):
        self.number = number
        self.weights = weights
        self.win_rate = win_rate
        self.heavy_win = heavy_win

def solution(weights, head2head):
    answer = []
    boxers = []
    for i in range(len(weights)):
        h2h = list(head2head[i])
        lose = 0
        win = 0
        heavy_win = 0
        for h in range(len(h2h)):
            if h2h[h] == "W":
                win += 1
                if weights[i] < weights[h]:
                    heavy_win += 1
            elif h2h[h] == "L":
                lose += 1
        if win == 0 and lose == 0:
            win_rate = 0
        else:
            win_rate = win/(lose+win)*100
        
        boxer_one = boxer(i+1,weights[i],win_rate,heavy_win)
        boxers.append(boxer_one)
    boxers = sorted(boxers,key=lambda x:(-x.win_rate,-x.heavy_win,-x.weights,x.number))
    for b in boxers:
        answer.append(b.number)
    return answer

weights = [50,82,75,120]
head2head = ["NLWL","WNLL","LWNW","WWLN"]
print(solution(weights,head2head))