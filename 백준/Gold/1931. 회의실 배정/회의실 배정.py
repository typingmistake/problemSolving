import sys
input = sys.stdin.readline

# 가능한 회의 개수
time_table_count = 0
time_table = []

N = int(input())
for i in range(N) :
    time_table.append(list(map(int,input().split())))

# 종료 시간, 시작 시간 순으로 정렬
time_table.sort(key=lambda x:(x[1],x[0]))

# 이전 작업 종료 시간
end_time = 0 

for i in range(N) :
    # 이전 작업 종료 시간이 현재 시작 시간보다 뒤
    if end_time <= time_table[i][0] :
        time_table_count += 1
        end_time = time_table[i][1]

print(time_table_count)