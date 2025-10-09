import sys
input = sys.stdin.readline

class Graph:
    def __init__(self, n):
        self.nodes = [[] for _ in range(n)]
    
    def addEdge(self, u, v):
        self.nodes[u].append(v)

N, M = map(int, input().split())
heights = list(map(int, input().split()))
dp = [1]*(N)

g = Graph(N)
for _ in range(M):
    a, b = map(int, input().split())
    if heights[a-1] < heights[b-1]:
        g.addEdge(a-1, b-1)
    else:
        g.addEdge(b-1, a-1)

nodes = [i for i in range(N)]
nodes.sort(key = lambda x: (-heights[x]))

for i in range(N):
    node = nodes[i]
    if(g.nodes[node]):
        dp[node] = max([dp[j] for j in g.nodes[node]]) + 1

for i in range(N):
    print(dp[i])