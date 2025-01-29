import sys
input = sys.stdin.readline

def solve(N,M):
    s = [[0,0]]
    visited = [[False for _ in range(N)] for _ in range(N)]
    while(s):
        x,y = s.pop()
        if(M[y][x]== -1):
            return True
        
        next = [[x+M[y][x],y],[x,y+M[y][x]]]
        for n in next:
            if(n[0]<N and n[1]<N and not visited[n[0]][n[1]]):
                s.append(n)
                visited[n[0]][n[1]] = True
    
    return False


N = int(input())
M = [list(map(int,input().split())) for _ in range(N)]

if(solve(N,M)):
    print("HaruHaru")
else:
    print("Hing")