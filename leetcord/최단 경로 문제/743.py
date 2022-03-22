# 네트워크 딜레이 타임
import math
import heapq

class Edge:
    def __init__(self,v,w):
        self.v = v
        self.w = w
    def __lt__(self,other):
        return self.w < other.w
    def __eq__(self,other):
        return self.w == other.w
class Solution(object):
    def networkDelayTime(self, times, n, k):
        """
        :type times: List[List[int]]
        :type n: int
        :type k: int
        :rtype: int
        다익스트라
        """
        dp = [math.inf] * (n+1)
        dp[0] = 0
        dp[k] = 0
        graph = [[] for _ in range(n+1)]
        pq = []
        for t in times:
            graph[t[0]].append(Edge(t[1],t[2]))
        pq.append(Edge(k,0))
        while pq:
            now = heapq.heappop(pq)
            if now.w > dp[now.v]: continue
            for e in graph[now.v]:
                if (dp[e.v] > dp[now.v] + e.w):
                    dp[e.v] = dp[now.v] + e.w
                    heapq.heappush(pq,e)
        answer = max(dp)
        if answer == math.inf:
            return -1
        else:
            return answer
                
times = [[2,1,1],[2,3,1],[3,4,1]]
n = 4
k = 2
print (Solution.networkDelayTime(0,times,n,k))