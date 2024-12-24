import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

N,M = map(int,input().split())
parent = [i for i in range(N+1)]

def find(num):
    global parent
    if num != parent[num]:
        parent[num] = find(parent[num])
    return parent[num]

for i in range(M):
    a,b,c = map(int,input().split())
    x,y = find(b),find(c)
    if a==0:
        if x<y:
            parent[y]=x
        elif x>y:
            parent[x]=y
    else:
        if x==y:
            print("YES")
        else:
            print("NO")