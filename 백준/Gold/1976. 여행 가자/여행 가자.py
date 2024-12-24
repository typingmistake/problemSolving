import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

parent = [i for i in range(N+1)]

def find(x):
    if(parent[x] != x):
        parent[x] = find(parent[x])
    return parent[x]

for i in range(1,N+1):
    paths = list(map(int,input().split()))
    for j in range(1,N+1):
        if paths[j-1]:
            p1,p2 = find(i), find(j)
            parent[p1],parent[p2] = min(p1,p2), min(p1,p2)
    

ans = 'YES'
nums = list(map(int,input().split()))

for i in range(M-1):
    if(find(nums[i])!=find(nums[i+1])):
        ans = 'NO'
        break

print(ans)