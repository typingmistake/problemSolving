import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

def solve(N,A,B):
    A.sort(reverse=True)
    B.sort()
    ans = 0
    for i in range(N):
        ans+= A[i]*B[i]
    
    return ans

print(solve(N,A,B))