import sys
input = sys.stdin.readline
from collections import deque


N,M = map(int,input().split())
nums = list(map(int,input().split()))
ans = 0
dq = deque([i for i in range(1,N+1)])

for num in nums:
    while(dq[0]!=num):
        idx = dq.index(num)
        ans+=1
        if(idx < len(dq)-idx):
            dq.append(dq.popleft())
        else:
            dq.appendleft(dq.pop())

    dq.popleft()


print(ans)
