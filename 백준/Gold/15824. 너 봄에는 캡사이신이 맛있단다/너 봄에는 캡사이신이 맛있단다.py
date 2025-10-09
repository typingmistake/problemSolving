import sys
input = sys.stdin.readline
MOD = 1_000_000_007

N = int(input())
nums = list(map(int,input().split()))
nums.sort()

dp = [0]*N

for i in range(1,N): # 각 자리에서 끝나는 경우
    # 경우의 수 추가, 값 추가(등비수열의 합)
    dp[i] = (2*dp[i-1] + (nums[i]-nums[i-1])*(2**i - 1)) % MOD

print(sum(dp)%MOD)