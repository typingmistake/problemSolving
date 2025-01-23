import sys
import math
input = sys.stdin.readline

T = int(input())

def solve(scores):
    m = sum(scores)/len(scores)
    res = 0
    for score in scores:
        if(score) > m:
            res +=1
    
    return math.ceil((100*res/len(scores))*1000)/1000


for i in range(T):
    scores = list(map(int, input().split(" "))) 
    print(f'{solve(scores[1:])}%')
