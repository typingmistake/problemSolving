import sys
input = sys.stdin.readline
from heapq import heappush, heappop, heapify

def solve(nums, N, K):
    heapify(nums)

    while((N-1) % (K-1) != 0):
        heappush(nums, 0)
        N += 1
    
    res = 0
    while(len(nums) > 1):
        curr = 0 # K개 합치기
        for _ in range(K):
            if(nums):
                curr += heappop(nums)
            else:
                break
        
        heappush(nums, curr)
        res += curr

    return res

T = int(input())

for _ in range(T):
    N, K = map(int,input().split())
    nums = list(map(int,input().split()))
    print(solve(nums, N, K))
