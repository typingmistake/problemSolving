import sys
input = sys.stdin.readline

ans = 0
N = int(input())
for i in range(N):
    c,k = map(int,input().split())
    ans += c*k

print(ans)