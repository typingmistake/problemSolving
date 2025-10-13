import sys
input = sys.stdin.readline

money = [500,100,50,10,5,1]

curr = 1000- int(input())
res = 0

for m in money:
    res += curr//m
    curr = curr%m

print(res)