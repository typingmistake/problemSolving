import sys
input = sys.stdin.readline

N = int(input())
n = N//3

s = [
    "  *   ",
    " * *  ",
    "***** "
]

M = [[" " for _ in range(2*N)] for _ in range(N)]

def solve(start, k):
    if k == 1:
        for i in range(3):
            for j in range(len(s[0])):
                M[start[0]-3+i][start[1]+j] = s[i][j]
    else:
        k //= 2
        solve(start, k)
        solve([start[0], start[1]+6*k], k)
        solve([start[0]-3*k, start[1]+3*k], k)

solve([3*n, 0], n)

for i in M:
    print(''.join(i))