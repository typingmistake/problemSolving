import sys
input = sys.stdin.readline

nums = []
N = int(input())

for i in range(N):
    nums.append(int(input()))

dp = [[0 for _ in range(N+1)] for _ in range(3)]

for i in range(N):
    dp[0][i+1] = max(dp[0][i], dp[1][i], dp[2][i])
    for j in range(2):
        dp[j+1][i+1] = dp[j][i] + nums[i]

print(max(dp[0][N], dp[1][N], dp[2][N]))