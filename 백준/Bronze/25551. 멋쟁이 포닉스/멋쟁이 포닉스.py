import sys
input = sys.stdin.readline


clothes = []
for _ in range(3):
    clothes.append(list(map(int, input().split())))

A = [1,0,1]
B = [0,1,0]

cntA = min(clothes[i][A[i]] for i in range(3))
cntB = min(clothes[i][B[i]] for i in range(3))

ans = min(cntA, cntB)*2

print(ans if cntA==cntB else ans+1)
