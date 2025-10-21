import sys
input = sys.stdin.readline
max_value = sys.maxsize

def solve(N, min_total, min_each):
    if(N <= 6):
        return min(min_each*N, min_total)
    
    return min(N*min_each, min_total*(N//6) + min_each*(N%6), min_total*(N//6 + 1))

N, M = map(int, input().split())
min_total, min_each = max_value, max_value

for _ in range(M):
    a,b = map(int,input().split())
    min_total, min_each = min(min_total, a), min(min_each, b)

print(solve(N, min_total, min_each))