import sys
input = sys.stdin.readline

def solve(str1, str2, N, M):
    result = []
    idx1 = 0
    idx2 = 0
    
    while idx1 < N and idx2 < M:
        max_val = -1
        next_idx1 = -1
        next_idx2 = -1

        for i in range(idx1, N):
            for j in range(idx2, M):
                if str1[i] == str2[j]:
                    if int(str1[i]) > max_val:
                        max_val = int(str1[i])
                        next_idx1 = i
                        next_idx2 = j
                    break 
        
        if max_val != -1:
            result.append(str(max_val))
            idx1 = next_idx1 + 1
            idx2 = next_idx2 + 1
        else:
            break
    
    return result

N = int(input())
str1 = list(input().split())
M = int(input())
str2 = list(input().split())

ans = solve(str1, str2, N, M)
print(len(ans))
if(len(ans) > 0):
    print(' '.join(ans))