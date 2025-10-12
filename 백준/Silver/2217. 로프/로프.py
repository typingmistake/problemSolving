import sys
input = sys.stdin.readline

N = int(input())
nums = []
for i in range(N):
    nums.append(int(input()))

nums.sort()
MAX = -1

for i in range(N):
    MAX = max(MAX, nums[i] * (N - i))

print(MAX)