import sys
input = sys.stdin.readline
INF = sys.maxsize

class graph:
    def __init__(self, n):
        self.num = n # 전체 노드 개수
        self.edges = {}
        for i in range(1,n+1):
            self.edges[i] = {} # node, value
    
    def add(self, u, v, c):
        self.edges[u][v] = c
        self.edges[v][u] = c


def solve(g, m, items):
    n = g.num
    costs = [[INF]*(n+1) for _ in range(n+1)]
    
    # 연결된 지점
    for i in range(1,n+1):
        costs[i][i] = 0
        for k,v in g.edges[i].items():
            costs[i][k] = v
    
    # 플로이드 워셜
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(n+1):
                costs[i][j] = min(costs[i][j], costs[i][k] + costs[k][j])
    
    result = -1
    for i in range(1, n+1): # 출발지점
        curr = 0
        for j in range(1, n+1):
            if(costs[i][j] <= m): # 수색범위 안
                curr+=items[j-1]
        result = max(result, curr)
    
    return result



n, m, r = map(int, input().split())
items = list(map(int, input().split()))
g = graph(n)

for _ in range(r):
    u, v, c = map(int, input().split())
    g.add(u,v,c)


print(solve(g, m, items))