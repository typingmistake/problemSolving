from itertools import combinations

def get_chicken_distance(homes, selected_chickens):
    total_distance = 0
    for home in homes:
        min_distance = float('inf')
        for chicken in selected_chickens:
            distance = abs(home[0] - chicken[0]) + abs(home[1] - chicken[1])
            min_distance = min(min_distance, distance)
        total_distance += min_distance
    return total_distance

def solve():
    N, M = map(int, input().split())
    
    # 집과 치킨집의 위치를 저장
    homes = []
    chickens = []
    for i in range(N):
        row = list(map(int, input().split()))
        for j in range(N):
            if row[j] == 1:  # 집
                homes.append((i+1, j+1))
            elif row[j] == 2:  # 치킨집
                chickens.append((i+1, j+1))
    
    # 가능한 모든 치킨집 조합에 대해 최소 거리 계산
    min_city_distance = float('inf')
    for selected in combinations(chickens, min(M, len(chickens))):
        distance = get_chicken_distance(homes, selected)
        min_city_distance = min(min_city_distance, distance)
    
    return min_city_distance

print(solve())