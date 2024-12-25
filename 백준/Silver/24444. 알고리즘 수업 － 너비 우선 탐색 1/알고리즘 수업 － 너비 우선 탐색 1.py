import sys
input = sys.stdin.readline
from collections import deque


class graph():
    def __init__(self,N):
        self.num = N
        self.nodes = {}
        for i in range(1,N+1):
            self.nodes[i] = []
    
    def addEdge(self,u,v):
        self.nodes[u].append(v)
        self.nodes[v].append(u)

def bfs(g,s):
    global rank
    visited = [False]*(g.num+1)
    visited[s] = True
    ans[s] = rank
    rank+=1
    q = deque([s])
    while(q):
        curr = q.popleft()
        for node in g.nodes[curr]:
            if(not visited[node]):
                visited[node] = True
                ans[node]=rank
                rank+=1
                q.append(node)

N,M,S = map(int,input().split())
g = graph(N)
for i in range(M):
    u,v = map(int,input().split())
    g.addEdge(u,v)


for k in g.nodes:
    g.nodes[k].sort()

rank = 1
ans = [0 for _ in range(N+1)]
bfs(g,S)

for i in range(1,N+1):
    print(ans[i])