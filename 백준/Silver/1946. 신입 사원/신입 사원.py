import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    stats = []
    for i in range(N):
        stats.append(list(map(int,input().split())))
    
    stats.sort()
    m = stats[0][1]
    ans = 1 # 서류성적 1등

    for i in range(1, N):
        curr = stats[i][1]
        if(curr < m): # 면접순위 우위
            ans += 1
            m = curr
    
    print(ans)