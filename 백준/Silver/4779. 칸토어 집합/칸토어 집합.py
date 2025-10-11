import sys
input = sys.stdin.readline

def solve(strs ,idx, N):
    if N == 1:
        return
    solve(strs, idx, N//3)
    solve(strs, idx + 2*N//3, N//3)

    for i in range(idx+N//3, idx+2*N//3):
        strs[i] = ' '

while True:
    try:
        N = int(input())
        strs = list('-'*(3**N))
        solve(strs, 0, 3**N)
        print(''.join(strs))
    except (EOFError, ValueError):
        break