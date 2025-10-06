import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

nums = [[A[i],i] for i in range(N)]
nums.sort()
ans = [0] * N

for i in range(N):
    ans[nums[i][1]] = i

print(' '.join(map(str, ans)))