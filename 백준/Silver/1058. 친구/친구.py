import sys
input = sys.stdin.readline

class Graph:
    def __init__(self,N):
        self.num = N
        self.nodes = {}
        for i in range(N):
            self.nodes[i] = []
    
    def addEdge(self,u,v):
        self.nodes[u].append(v)
        self.nodes[v].append(u)


N = int(input())

g = Graph(N)
for i in range(N):
    seq = list(input().strip())
    for j in range(len(seq)):
        if(seq[j]=='Y'):
            g.addEdge(i,j)


count = [0 for _ in range(N)]

for i in range(N):
    visited = [False]*N
    for node in g.nodes[i]:
        visited[node] = True
        for n in g.nodes[node]:
            if(not visited[n] and n!=i):
                visited[n] = True
    
    count[i] = sum(visited)

print(max(count))
    


