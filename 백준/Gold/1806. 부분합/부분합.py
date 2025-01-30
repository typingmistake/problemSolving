import sys
input = sys.stdin.readline

def solve(N,S,nums):
    if(sum(nums) < S):
        return 0
    left = 0
    ans = N
    s = 0
    for right in range(N):
        s+=nums[right]
        while(s-nums[left]>=S):
            s-=nums[left]
            left+=1
        
        if(s>=S):
            ans = min(ans, right-left+1)
    
    return ans



N, S = map(int,input().split())
nums = list(map(int,input().split()))
print(solve(N,S,nums))