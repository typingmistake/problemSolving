import sys
input = sys.stdin.readline

def solve(num):
    res = ['V']*4
    n = 3
    while(num > 0):
        if(num%2 == 1):
            res[n] = "딸기"
        num //= 2
        n-=1
    return res

T = int(input())

for _ in range(T):
    N = int(input())
    
    num = (N-1)%28 # 0 베이스
    if(num >= 15):
        num = 13-num%15

    print(''.join(solve(num+1)))