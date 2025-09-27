import sys
input = sys.stdin.readline
from heapq import heappop, heappush


nums = []
N = int(input())
pq = []

for _ in range(N):
    nums = list(map(int, input().split()))
    for num in nums:
        if len(pq) < N:
            heappush(pq, num)
        elif num > pq[0]:
            heappop(pq) # -1
            heappush(pq, num) # +1

print(pq[0])