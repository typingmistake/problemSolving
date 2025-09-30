import sys
input = sys.stdin.readline

def isValid(nums):
    target = nums[:len(nums)-1]
    m =int(nums[-1])

    res = 0
    for i in range(len(target)):
        if i % 2 == 0:
            res += int(target[i]) * 1
        else:
            res += int(target[i]) * 3
    
    check_digit = (10 - res % 10) % 10
    
    return m == check_digit


nums = list(input().strip())
idx = -1

for i in range(len(nums)):
    if(nums[i] == '*'):
        idx = i
        break

for num in range(0, 10):
    nums[idx] = str(num)
    if(isValid(nums)):
        print(num)
        break