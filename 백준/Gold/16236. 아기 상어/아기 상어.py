import sys
from collections import deque
input = sys.stdin.readline

#수조 공간
space = []
N = int(input())
for i in range(N):
    space.append(list(map(int,input().split())))
#상어의 사이즈 기본값 2
sharkSize = 2
sec = 0
#상어가 먹은 먹이의 수
preyCount = 0
dy = [-1,0,0,1]
dx = [0,-1,1,0]
#처음 상어 위치 탐색
for i in range(N) :
        for j in range(N):
            if space[i][j] == 9:
                shark = [i,j] # 상어의 처음 위치
                space[i][j] = 0
while True :
    #먹이 존재 여부 탐색
    preyflag = 0
    for i in range(N) :
        for j in range(N):
            if 0 < space[i][j] < sharkSize :
                preyflag = 1
                break
        if preyflag == 1:
            break
    # 더이상 먹이가 없으면, 탈출
    if preyflag == 0:
        break
    else :
        visited = [[False for _ in range(N)]for _ in range(N)]
        dq = deque()
        dq.append(shark)
        visited[shark[0]][shark[1]] = True
        preyList = []
        currentCount = 1
        nextCount = 0
        tmp_sec = 0
        result_flag = 0
        while dq :
            tmp = dq.popleft()
            currentCount -= 1
            #상어가 지나갈 수 있는 길
            if space[tmp[0]][tmp[1]] <= sharkSize :
                # 먹이를 찾음
                if space[tmp[0]][tmp[1]] != 0 and sharkSize != space[tmp[0]][tmp[1]] :
                    preyList.append([tmp[0],tmp[1]])
                else :
                    for i in range(4):
                        if(0<= tmp[0]+dy[i] <= N-1 and 
                           0<= tmp[1]+dx[i] <= N-1 and
                           visited[tmp[0]+dy[i]][tmp[1]+dx[i]] == False) :
                            dq.append([tmp[0]+dy[i],tmp[1]+dx[i]])
                            visited[tmp[0]+dy[i]][tmp[1]+dx[i]] = True
                            nextCount += 1
            if currentCount == 0 :
                currentCount = nextCount
                nextCount = 0
                if len(preyList) > 0 : #최단거리 물고기를 발견한 경우
                    preyList.sort() #우선순위에따라 물고기 정렬
                    space[preyList[0][0]][preyList[0][1]] = 0 #해당 칸 비우기
                    shark = [preyList[0][0],preyList[0][1]] # 상어 위치 갱신
                    preyCount+=1
                    result_flag = 1
                    break
                tmp_sec+=1
        if preyCount == sharkSize :
            sharkSize += 1
            preyCount = 0
        #먹이를 못찾고 종료된 경우
        if result_flag == 0 :
            break
        else:
            sec += tmp_sec
print(sec)