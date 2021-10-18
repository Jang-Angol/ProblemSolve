from collections import deque

def maxProfit(self, prices: List[int]) -> int:
    prices = deque(prices)
    profit = []
    while prices:
        price = prices.popleft()
        for i, p in enumerate(prices):
            if p > price:
                profit.append(prices[i] - price)
            else:
                break
    if profit:
        return max(profit)
    return 0