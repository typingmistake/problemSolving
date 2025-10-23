import sys
input = sys.stdin.readline
INF = sys.maxsize

def solve(N, graph):
    dp = [row[:] for row in graph]
    dp[0][0] = dp[0][2] = INF
    prevs = [[0,1],[0,1,2],[1,2]]

    dp[0][1] = min(dp[0][1], dp[0][0] + graph[0][1])
    dp[0][2] = min(dp[0][2], dp[0][1] + graph[0][2])

    for i in range(1, N):
        for j in range(3): # 수직 전파
            dp[i][j] = min(dp[i-1][prev] for prev in prevs[j]) + graph[i][j]
        
        # 수평 오른쪽 전파
        dp[i][1] = min(dp[i][1], dp[i][0] + graph[i][1])
        dp[i][2] = min(dp[i][2], dp[i][1] + graph[i][2])
    
    return dp[N-1][1] # 마지막 행 두번째 열


N = int(input())
idx = 1
while(N!=0):
    graph = []

    for _ in range(N):
        graph.append(list(map(int, input().split())))

    print(f'{idx}. {solve(N,graph)}')
    idx+=1
    N = int(input())