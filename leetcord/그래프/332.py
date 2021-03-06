from collections import defaultdict

def findItinerary(tickets):
    graph = defaultdict(list)
    for s,d in sorted(tickets, reverse = True):
        graph[s].append(d)
    route = []
    def dfs(s):
        while graph[s]:
            dfs(graph[s].pop())
        route.append(s)
    dfs("JFK")
    return route[::-1]

tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]

print(findItinerary(tickets))