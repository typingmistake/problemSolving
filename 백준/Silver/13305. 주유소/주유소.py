import sys
input = sys.stdin.readline

N = int(input())

dist = list(map(int, input().split()))
cost = list(map(int, input().split()))
min_cost = cost[0] # 지금까지 만난 주유소 중에 가잔 싼 곳의 가격
res = dist[0]*min_cost

# i번째 도시 도착
for i in range(1,N-1):
    if(cost[i] < min_cost):
        min_cost = cost[i]
    
    res += dist[i]*min_cost

print(res)