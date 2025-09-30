import sys
input = sys.stdin.readline
from collections import deque

left = deque(list(input().strip())) # 커서 왼쪽
right = deque() # 커서 오른쪽
M = int(input())

for _ in range(M):
    cmd = list(input().split())
    if(cmd[0] == 'L' and left):
        right.appendleft(left.pop())
    if(cmd[0] == 'D' and right):
        left.append(right.popleft())
    if(cmd[0] == 'B' and left):
        left.pop()
    if(cmd[0] == 'P'):
        left.append(cmd[1])


print(''.join(left)+''.join(right))