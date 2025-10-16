import sys
input = sys.stdin.readline

def calc(k):
    return k * (k + 1) * (k + 2) // 6


N = int(input())
nums = input().strip() + '-'
ans = 0
curr = 0

for i in range(N+1):
    if(nums[i]=='2'):
        curr+=1
        continue

    if(curr > 0):
        ans += calc(curr)

    curr = 0

print(ans)