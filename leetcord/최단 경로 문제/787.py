# K 경유지 내 가장 저렴한 항공권
# 사이클을 확인할 필요가 있음
import heapq
from collections import defaultdict

class Solution(object):
    def findCheapestPrice(self, n, flights, src, dst, K):
        """
        :type n: int
        :type flights: List[List[int]]
        :type src: int
        :type dst: int
        :type k: int
        :rtype: int
        """
        graph = defaultdict(list)
        visited = [[0 for _ in range(n)] for __ in range(n)]
        
        for u,v,w in flights:
            graph[u].append((v,w))
        
        pq = [(0,src,K)]
        while pq:
            price, node, k = heapq.heappop(pq)
            if node == dst:
                return price
            if k >= 0:
                for v, w in graph[node]:
                    if visited[node][v] > 5:
                        continue
                    visited[node][v] += 1
                    heapq.heappush(pq,(price+w,v,k-1))            
        return -1
        
n = 4
flights = [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
src = 0
dst = 3
k = 1
print(Solution.findCheapestPrice(0,n,flights,src,dst,k))
        