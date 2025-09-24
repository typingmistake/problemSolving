import sys
input = sys.stdin.readline

def solve(items, c):
    start = 0
    end = items[-1] - items[0]
    
    while(start <= end):
        if(start==end):
            return start
        pivot = (end + start + 1)//2 # upper mid

        if(check(items, pivot, c)):
            start=pivot
            continue
        
        end=pivot-1
    
    return -1

def check(items, d, c):
    cnt = 0
    prev = items[0]

    for item in items[1:]:
        if(item-prev >= d):
            cnt+=1
            prev=item
    
    return cnt >= c


N, C = map(int,input().split())
items = []

for _ in range(N):
    items.append(int(input()))

items.sort()

print(solve(items, C-1))