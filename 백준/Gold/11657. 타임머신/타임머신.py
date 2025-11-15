import sys
input = sys.stdin.readline
INF = sys.maxsize

N,M = map(int,input().split())

class graph:
    def __init__(self,N):
        self.num_of_node = N
        self.edges = {}
        for i in range(1,N+1):
            self.edges[i] = {}
    
    def add_edge(self,u,v,w):
        if v in self.edges[u]:
            self.edges[u][v] = min(self.edges[u][v],w)
        else:
            self.edges[u][v] = w

def bellman_ford(dist,g):
    is_updated = False
    dist[1] = 0
    for _ in range(1,g.num_of_node+1):
        for node in range(1,g.num_of_node+1):
            if dist[node] != INF:
                for next,weight in g.edges[node].items():
                    if dist[node] + weight < dist[next]:
                        dist[next] = dist[node] + weight
                        is_updated = True
    
    return is_updated
    
    
g = graph(N)
for _ in range(M):
    u,v,w = map(int,input().split())
    g.add_edge(u,v,w)

dist = [INF]*(g.num_of_node+1)
bellman_ford(dist,g)

if bellman_ford(dist,g) == True:
    print(-1)
else:
    for i in range(2,N+1):
        if dist[i] != INF:
            print(dist[i])
        else:
            print(-1)




