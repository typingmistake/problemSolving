import sys
input = sys.stdin.readline
from heapq import heappop, heappush, heapify

def solve(pq):
    heapify(pq)
    res = 0
    while(len(pq) > 1):
        a = heappop(pq)
        b = heappop(pq)
        heappush(pq, a+b)
        res += a+b
    return res

T = int(input())

for _ in range(T):
    K = int(input())
    nums = list(map(int, input().split()))
    print(solve(nums))