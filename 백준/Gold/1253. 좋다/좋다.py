import sys
input = sys.stdin.readline

def solve(nums, N):
    res = 0

    for idx in range(N):
        if(check(nums, idx, 0, N-1)):
            res += 1

    return res

def check(nums, idx, start, end):
    target = nums[idx]

    while(start < end):
        if(end == idx):
            end-=1
            continue

        if(start == idx):
            start+=1
            continue

        curr = nums[end] + nums[start]
        if(curr==target):
            return True
        if(curr > target):
            end-=1
            continue

        start+=1

    return False

N = int(input())
nums = list(map(int,input().split()))
print(solve(sorted(nums), N))