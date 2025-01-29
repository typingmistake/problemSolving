import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
a,b = map(int,input().split())

print(sum([(num+a-1)//a for num in nums]))
print(N//b, N%b)