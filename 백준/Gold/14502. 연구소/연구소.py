import sys
input = sys.stdin.readline
from collections import deque
INF = sys.maxsize

def solve(lab, cand, curr, virs, N, M):
    if(len(curr) == 3):
        new_lab = [row[:] for row in lab]

        for y,x in curr:
            new_lab[y][x] = 1 # 벽 세우기
        
        return getSize(new_lab, virs, N, M)
    
    res = INF

    for c in cand:
        if c not in curr:
            curr.add(c)
            res = min(res, solve(lab,cand,curr,virs,N,M))
            curr.remove(c)
    
    return res


def getSize(lab, virs, N, M):
    visited = set()
    dy = [0,0,-1,1]
    dx = [-1,1,0,0]
    q = deque(virs)
    for v in virs:
        visited.add(v)
    size = 0
    
    while(q):
        y,x = q.popleft()

        for ny, nx in [(y+dy[i], x+dx[i]) for i in range(4)]:
            if (0<=ny<N and 0<=nx<M and lab[ny][nx] == 0 and (ny,nx) not in visited):
                q.append((ny,nx))
                visited.add((ny,nx))
                size +=1
    
    return size

lab = []
cand = [] # 빈 공간
virs = [] # 바이러스 위치

N,M = map(int, input().split())

for i in range(N):
    lab.append(list(map(int, input().split())))
    for j in range(M):
        if(lab[i][j] == 0):
            cand.append((i,j))
        if(lab[i][j] == 2):
            virs.append((i,j))

print(len(cand) - 3 - solve(lab, cand, set(), virs, N, M))