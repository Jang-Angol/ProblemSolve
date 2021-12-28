# 로또
from itertools import combinations

start = True

while True:
    array = list(map(int,input().split()))
    if len(array) == 1:
        break
    if not start:
        print(" ")
    else:
        start = False
    comb = combinations(array[1:],6)
    for case in comb:
        for n in case:
            print(n,end=" ")
        print()
