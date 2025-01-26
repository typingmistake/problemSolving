import sys
input = sys.stdin.readline

E, S , M = map(int, input().split())

def solve(E,S,M):
    num = 0
    while True:
        if num%15 == E-1 and num%28 == S-1 and num%19 == M-1:
            return num+1
        num+=1
    
print(solve(E,S,M))