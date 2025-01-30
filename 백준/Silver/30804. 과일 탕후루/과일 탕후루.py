import sys
input = sys.stdin.readline

def solve(fruits,N):
    res = 0
    j = 0
    M = {}
    for i in range(N):
        M[fruits[i]] = M.get(fruits[i],0) + 1
        
        while(len(M) > 2):
            if(M[fruits[j]]==1):
                del M[fruits[j]]
            else:
                M[fruits[j]]-=1
            j+=1
        
        res = max(res, i-j+1)
    
    return res


N = int(input())
f = list(map(int,input().split()))
print(solve(f,N))