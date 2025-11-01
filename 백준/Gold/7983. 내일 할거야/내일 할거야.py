import sys
input = sys.stdin.readline

N = int(input())
res = []

for _ in range(N):
    d,t = map(int, input().split())
    res.append([t,d])

res.sort(reverse=True)

ans = res[0][0] # 마감기한
for t,d in res:
    if(t < ans):
        ans = t-d
    else:
        ans-=d

print(ans)




