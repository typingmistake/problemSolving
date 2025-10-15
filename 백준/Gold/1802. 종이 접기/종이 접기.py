import sys
input = sys.stdin.readline

def solve(nums, end):
    p = end//2
    for i in range(p):
        if(nums[i] == nums[end-i-1]):
            return False
    
    return solve(nums,p) if p > 1 else True

T = int(input())
for _ in range(T):
    nums = list(input().strip())
    if(solve(nums, len(nums))):
        print("YES")
        continue

    print("NO")