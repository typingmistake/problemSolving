import sys
input = sys.stdin.readline
from collections import deque

def solve(x, y, h, map, visited, N, M):
    nexts = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    q = deque([(x, y)])
    visited[x][y] = True

    while q:
        (x, y) = q.popleft()

        for dx, dy in nexts:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M:
                if map[nx][ny] > h and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx, ny))


N = int(input())
visited = [[False] * N for _ in range(N)]

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split(" "))))

min_height = min(graph[i][j] for i in range(N) for j in range(N))
max_height = max(graph[i][j] for i in range(N) for j in range(N))

ans = 0

for h in range(min_height-1, max_height):
    cnt = 0
    visited = [[False] * N for _ in range(N)]
    
    for i in range(N):
        for j in range(N):
            if graph[i][j] > h and not visited[i][j]:
                solve(i, j, h, graph, visited, N, N)
                cnt += 1

    ans = max(ans, cnt)

print(ans)