import sys
input = sys.stdin.readline

A,B,N = map(int,input().split())

for i in range(N):
    A%=B
    A*=10

print(A//B)