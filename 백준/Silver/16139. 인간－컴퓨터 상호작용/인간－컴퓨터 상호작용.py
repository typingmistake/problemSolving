import sys
input = sys.stdin.readline

def solve(cnts, c, s, e):
    return cnts[e][ord(c) - ord('a')] - (0 if s == 0 else cnts[s-1][ord(c) - ord('a')])

S = list(input().strip())
Q = int(input())
N = len(S)

cnts = [[0]*26 for _ in range(N)]
cnts[0][ord(S[0]) - ord('a')] += 1

for i in range(1, N):
    c = S[i]
    cnts[i] = cnts[i-1][:]
    cnts[i][ord(c) - ord('a')] += 1

for _ in range(Q):
    c, s, e = input().split()
    print(solve(cnts, c, int(s), int(e)))