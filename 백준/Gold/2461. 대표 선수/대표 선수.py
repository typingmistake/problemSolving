import sys
input = sys.stdin.readline

def solve(arr, N):
    res = sys.maxsize
    curr = 0 # 현재 포함되는 학급의 수
    cnt = [0]*N
    
    start = 0
    for end in range(len(arr)):
        end_num, end_idx = arr[end]

        if(cnt[end_idx]==0):
            curr+=1
        cnt[end_idx]+=1

        
        if(curr < N):
            continue

        while(curr == N):
            start_num, start_idx = arr[start]
            res = min(res, end_num-start_num)
            # start 전진
            cnt[start_idx]-=1
            start+=1
            if(cnt[start_idx] == 0):
                curr-=1
    
    return res


N, M = map(int, input().split())
nums = []
for _ in range(N):
    nums.append(list(map(int, input().split())))

arr = []
for i in range(N):
    for j in range(M): # 능력치, 반 번호
        arr.append([nums[i][j],i])

arr.sort()
print(solve(arr, N))
