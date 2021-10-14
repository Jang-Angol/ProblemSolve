from collections import deque

def solution(prices):
    answer = []
    
    prices = deque(prices)
    
    while prices:
        origin_price = prices.popleft()
        time = 0
        for price in prices:
            time += 1
            if price < origin_price:
                break
        answer.append(time)

    return answer