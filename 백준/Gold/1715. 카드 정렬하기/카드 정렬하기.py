import sys
input = sys.stdin.readline
from heapq import heappop, heappush, heapify

N = int(input())
nums = []
for _ in range(N):
    nums.append(int(input()))

heapify(nums)
ans = 0
while len(nums) > 1:
    a, b = heappop(nums), heappop(nums)
    ans += a + b
    heappush(nums, a + b)

print(ans)