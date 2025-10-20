import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
M = int(input())
C = list(map(int, input().split()))

result = []
cnt = 0
for i in range(N-1,-1,-1):
    if(cnt >= M):
        break
    
    if A[i] == 0:
        result.append(B[i])
        cnt+=1

for i in range(M-cnt):
    result.append(C[i])

print(' '.join(map(str, result)))