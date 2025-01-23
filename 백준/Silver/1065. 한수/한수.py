import sys
input = sys.stdin.readline

N = int(input())

count = 0

def is_hansu(n):
    if n < 100:
        return True
    
    n_1,n_2,n_3 = n//100, n%100//10, n%10
    if (n_1 - n_2 == n_2 - n_3):
        return True
    
    return False

for i in range(1,N+1):
    if(is_hansu(i)):
        count+=1


print(count)