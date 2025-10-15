import sys
input = sys.stdin.readline

N = int(input())
nums = []
for _ in range(N):
    nums.append(int(input()))

nums.sort(reverse=True)
ans = sum(nums)

for i in range(1,N+1):
    if(i%3==0):
        ans -= nums[i-1]

print(ans)