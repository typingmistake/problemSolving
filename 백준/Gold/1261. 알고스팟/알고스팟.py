import sys
input = sys.stdin.readline
from heapq import heappop, heappush

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def dijstra(maze, r, c):
    pq = [(0,0,0)] # 비용, y, x
    visited = [[False]*c for _ in range(r)]

    while(pq):
        cost,y,x = heappop(pq)
        if(visited[y][x]):
            continue

        visited[y][x] = True
        if(y==r-1 and x==c-1):
            return cost
        
        nexts = [[y+dy[i], x+dx[i]] for i in range(4)]
        for ny, nx in nexts:
            if(0<=ny<r and 0<=nx<c and not visited[ny][nx]):
                if(maze[ny][nx]=='0'): # 벽 부수지 않고 전진
                    heappush(pq, [cost, ny, nx])
                if(maze[ny][nx]=='1'): # 벽 부수고 전진
                    heappush(pq, [cost+1, ny, nx])
        

c, r = map(int,input().split())
maze = []

for _ in range(r):
    maze.append(list(input().strip()))

print(dijstra(maze, r, c))