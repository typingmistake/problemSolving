import sys
input = sys.stdin.readline

N = int(input())
n,m = N//10, N%10
ans = N
cnt = 0

def solve(n,m,ans):
    cnt = 0
    while True:
        new = m*10 + (n+m)%10
        cnt += 1
        if(new == ans):
            return cnt
        
        n,m = new//10, new%10

print(solve(n,m,ans))

