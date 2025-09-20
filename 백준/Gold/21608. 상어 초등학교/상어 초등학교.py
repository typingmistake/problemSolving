import sys
input = sys.stdin.readline
from collections import deque

# 학생 배치
def arr(room, stud, num, N):
    max_value = -1
    cand = []  # 자리 후보
    
    # 주변 선호 학생 수 계산
    for r in range(N):
        for c in range(N):
            if room[r][c] != 0:  # 이미 자리가 차있으면 건너뛰기
                continue
                
            nears = [[r-1, c], [r+1, c], [r, c-1], [r, c+1]]
            cnt = 0
            for ny, nx in nears:
                if ny < 0 or ny >= N or nx < 0 or nx >= N:
                    continue
                if room[ny][nx] in stud:
                    cnt += 1
            
            if cnt > max_value:
                max_value = cnt
                cand = [[r, c]]
            elif cnt == max_value:
                cand.append([r, c])
                
    if len(cand) == 1:
        y, x = cand[0]
        room[y][x] = num 
        return
    
    # 후보지가 많은 경우에는 빈 칸 조사
    max_empty = -1
    final_cand = []
    
    for y, x in cand:
        nears = [[y-1, x], [y+1, x], [y, x-1], [y, x+1]]
        empty_cnt = 0
        for ny, nx in nears:
            if ny < 0 or ny >= N or nx < 0 or nx >= N:
                continue
            if room[ny][nx] == 0:
                empty_cnt += 1
        
        if empty_cnt > max_empty:
            max_empty = empty_cnt
            final_cand = [[y, x]]
        elif empty_cnt == max_empty:
            final_cand.append([y, x])
    
    final_cand.sort()
    y, x = final_cand[0]
    room[y][x] = num

# 선호도 계산
def calculate(room, stud, r, c, N):
    nexts = [[r-1, c], [r+1, c], [r, c-1], [r, c+1]]
    cnt = 0
    for ny, nx in nexts:
        if ny < 0 or ny >= N or nx < 0 or nx >= N:
            continue
        if room[ny][nx] in stud:
            cnt += 1
    
    if cnt > 0:
        return 10**(cnt-1)
    else:
        return 0

N = int(input())
# 교실 (0이면 빈 칸)
room = [[0]*N for _ in range(N)]
studs = [[] for _ in range(N*N+1)]
order = []

# 학생 선호도
for _ in range(N*N):
    nums = list(map(int, input().split()))
    studs[nums[0]] = set(nums[1:])
    order.append(nums[0])

# 학생 배치
for student_num in order:
    arr(room, studs[student_num], student_num, N)

ans = 0
for r in range(N):
    for c in range(N):
        stud_idx = room[r][c]
        ans += calculate(room, studs[stud_idx], r, c, N)

print(ans)