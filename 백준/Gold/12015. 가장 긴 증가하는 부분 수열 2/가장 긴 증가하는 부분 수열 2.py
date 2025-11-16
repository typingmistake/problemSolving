import sys
input = sys.stdin.readline

def binary(nums,target):
    start = 0
    end = len(nums)-1
    while(start <= end):
        pivot = (end+start)//2
        if nums[pivot] == target:
            return pivot
        elif nums[pivot] < target:
            start = pivot+1
        else:
            end = pivot-1
            
    return start
            

def lcs(nums):
    stack = []
    for num in nums:
        if stack:
            if num > stack[-1]:
                stack.append(num)
            elif num < stack[-1]:
                stack[binary(stack,num)] = num
        else:
            stack.append(num)
            
    return len(stack)

n = int(input())
nums = list(map(int,input().split()))

print(lcs(nums))