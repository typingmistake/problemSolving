import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
nums = list(map(int, input().split()))
s = int(input())


def solve(s, n, nums):
    visited = [False] * n
    q = deque()
    q.append(s)
    visited[s] = True

    while(q):
        curr = q.popleft()
        nexts = [curr-nums[curr], curr+nums[curr]]

        for next in nexts:
            if(0<=next<n and not visited[next]):
                q.append(next)
                visited[next] = True
    
    return sum(visited)

print(solve(s-1,n,nums))