from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)
    for s,d in sorted(tickets, reverse = True):
        graph[s].append(d)
    route = []
    def dfs(s):
        while graph[s]:
            dfs(graph[s].pop())
        route.append(s)
    dfs("ICN")
    return route[::-1]