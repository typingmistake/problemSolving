import sys
input = sys.stdin.readline
from collections import deque


N = int(input())
nums = [0] + list(map(int,input().split()))
ans = []
b = [i for i in range(1,N+1)]
dq = deque(b)
s = 0
while(len(ans)!=N):
    if(s>0):
        for i in range(s-1):
            dq.append(dq.popleft())

    elif(s<0):
        for i in range(-s):
            dq.appendleft(dq.pop())

    s = nums[dq[0]]
    ans.append(dq.popleft())


print(*ans)
