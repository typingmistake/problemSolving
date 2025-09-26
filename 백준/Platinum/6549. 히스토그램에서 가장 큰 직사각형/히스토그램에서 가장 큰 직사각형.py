import sys
input = sys.stdin.readline

def solve(nums, n):
    stack = []
    res = 0
    
    for i in range(n):
        # 현재 높이보다 큰 높이들을 스택에서 제거
        while stack and nums[stack[-1]] > nums[i]:
            h = nums[stack.pop()]
            w = i if not stack else i - stack[-1] - 1
            res = max(res, h*w)
        
        stack.append(i)
    
    while stack:
        h = nums[stack.pop()]
        w = n if not stack else n - stack[-1] - 1
        res = max(res, h * w)
    
    return res

while True:
    nums = list(map(int, input().split()))
    if len(nums) == 1:
        break
    print(solve(nums[1:], nums[0]))