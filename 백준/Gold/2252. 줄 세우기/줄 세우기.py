import sys
input = sys.stdin.readline
from collections import deque

class graph:
    def __init__(self, N):
        self.nodes = N
        self.degrees = [0]*(N+1)
        self.edges = {}

        for i in range(1,N+1):
            self.edges[i] = []

    def add_edge(self, u, v):
        self.degrees[v] += 1
        self.edges[u].append(v)
        
def solve(g):
    q = deque()
    result = []
    
    for i in range(1, g.nodes+1):
        if(g.degrees[i]==0):
            q.append(i)
            result.append(str(i))
    
    while(q):
        cur = q.popleft()

        for next in g.edges[cur]:
            g.degrees[next] -= 1

            if(g.degrees[next] == 0):
                q.append(next)
                result.append(str(next))
    
    return result


N, M = map(int,input().split())

g = graph(N)
for i in range(M):
    u, v = map(int,input().split())
    g.add_edge(u,v)

print(' '.join(solve(g)))

