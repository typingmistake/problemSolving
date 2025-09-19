import sys
input = sys.stdin.readline

max_value = -sys.maxsize  # 최대값
min_value = sys.maxsize   # 최소값


def solve(N, curr, idx, nums, cnts):
    if(idx == N):
        global max_value, min_value
        max_value = max(max_value, curr)
        min_value = min(min_value, curr)
        return
    
    if(cnts[0] > 0): # 덧셈
        cnts[0] -= 1
        solve(N, curr + nums[idx], idx + 1, nums, cnts)
        cnts[0] += 1
    if(cnts[1] > 0): # 뺄셈
        cnts[1] -= 1
        solve(N, curr - nums[idx], idx + 1, nums, cnts)
        cnts[1] += 1
    if(cnts[2] > 0): # 곱셈
        cnts[2] -= 1
        solve(N, curr * nums[idx], idx + 1, nums, cnts)
        cnts[2] += 1
    if(cnts[3] > 0): # 나눗셈
        cnts[3] -= 1
        if(curr < 0): # 음수
            solve(N, -(-curr // nums[idx]), idx + 1, nums, cnts)
        else:
            solve(N, curr // nums[idx], idx + 1, nums, cnts)
        cnts[3] += 1


N = int(input())
nums = list(map(int, input().split()))

# 덧셈, 뺄셈, 곱셈, 나눗셈
cnts = list(map(int, input().split()))

solve(N, nums[0], 1, nums, cnts)

print(max_value)
print(min_value)
