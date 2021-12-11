# 이분 탐색
N = int(input())

numbers = list(map(int,input().split()))

array = [numbers[0]]

def binary_search(start,end,target):
    if start > end:
        return start
    mid = (start+end)//2
    if array[mid] > target:
        return binary_search(start,mid-1,target)
    elif array[mid] == target:
        return mid
    else:
        return binary_search(mid+1,end,target)

for i in range(1,len(numbers)):
    if numbers[i] > array[-1]:
        array.append(numbers[i])
    else:
        idx = binary_search(0,len(array)-1,numbers[i])
        array[idx] = numbers[i]

print(len(array))
