import sys
input = sys.stdin.readline

N = int(input())

def solve(N,files):
    ans = ''
    for i in range(len(files[0])):
        for j in range(1,N):
            if files[j][i] != files[j-1][i]:
                ans += '?'
                break

        if len(ans)==i:
            ans += files[0][i]
    
    return ans


files = [input().strip() for _ in range(N)]

print(solve(N,files))