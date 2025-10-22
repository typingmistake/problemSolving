import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()
totalSum = sum(nums)

prev = nums[0]
prevSum = nums[0]
min_val = 20_000*10_000
ans = nums[0]

for i in range(1,N):
    curr = nums[i]
    for k in range(prev, curr):
        val = k*i-prevSum + totalSum-prevSum-(N-i)*k
        if(min_val > val):
            ans = k
            min_val = val

    prev = curr
    prevSum += prev

print(ans)