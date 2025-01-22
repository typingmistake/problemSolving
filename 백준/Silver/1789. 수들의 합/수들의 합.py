import sys
input = sys.stdin.readline

N = int(input())

def solve(N,cnt,ans):
    while N >= 0:
        N -= cnt
        cnt += 1
        ans += 1
    return ans-1

print(solve(N,1,0))