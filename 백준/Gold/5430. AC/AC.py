import sys
from collections import deque
input = sys.stdin.readline
delete = 'D'
reverse = 'R'

T = int(input())

for i in range(T):
    functions = list(input().strip())
    n = int(input())
    
    nums = deque(input().strip()[1:-1].split(','))
    if n == 0:
        nums = deque()
    
    reverse_flag = False
    error_flag = False
    
    for function in functions:
        if function == reverse:
            reverse_flag = not reverse_flag
        elif function == delete:
            if not nums:
                print("error")
                error_flag = True
                break
            else:
                if reverse_flag:
                    nums.pop()
                else:
                    nums.popleft()
    
    if error_flag == False:
        if reverse_flag == True:
            nums.reverse()
            print("["+",".join(nums)+"]")
        else:
            print("["+",".join(nums)+"]")