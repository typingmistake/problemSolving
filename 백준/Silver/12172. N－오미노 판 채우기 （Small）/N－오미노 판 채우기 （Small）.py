import sys
input = sys.stdin.readline

def solve(x,r,c):
    if(x==1):
        return False
    if(x==2):
        if(r*c%2==0):
            return False
        return True
        
    if(x==3):
        # 1x1, 1x2, 2x2
        if(r<x and c<x):
            return True
        # 1x3, 1x4
        if(r<x-1 or c<x-1):
            return True
        # 2x4, 4x4
        if(r%2==0 and c%2==0):
            return True
        # 2x3, 3x3, 3x4
        return False
    
    # 1x1, 1x2, 1x3, 2x2, 2x3 3x3
    if(r<x and c<x):
        return True
    # 1x4 2x4
    if(r<x-1 or c<x-1):
        return True

    # 3x4, 4x4
    return False


T = int(input())
for i in range(1,T+1):
    x,r,c = map(int,input().split())
    if(solve(x,r,c)):
        print(f'Case #{i}: RICHARD')
    else:
        print(f'Case #{i}: GABRIEL')



