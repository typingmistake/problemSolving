import sys
input = sys.stdin.readline
import re

pattern = re.compile('^(100+1+|01)+$')


T = int(input())
for _ in range(T):
    if(pattern.match(input().strip())):
        print("YES")
    else:
        print("NO")
