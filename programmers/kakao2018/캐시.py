from collections import deque

def solution(cacheSize, cities):
    answer = 0
    cache = deque([])
    for city in cities:
        city = city.lower()
        if cacheSize == 0:
            answer += 5
        elif city not in cache:
            if len(cache) == cacheSize:
                cache.popleft()
                cache.append(city)
                answer += 5
            else:
                cache.append(city)
                answer += 5
        else:
            cache.remove(city)
            cache.append(city)
            answer += 1
    return answer

cacheSize = 0
cities = 	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
print(solution(cacheSize,cities))