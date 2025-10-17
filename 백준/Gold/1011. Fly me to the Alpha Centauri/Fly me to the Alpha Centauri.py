import sys
input = sys.stdin.readline

def calc(end):
    curr = 1
    result = 1
    value = 1 # 처음에는 1 선택

    while(curr<end):
        for k in (value+1, value, value-1):
            next = curr+k
            if(check(k,end-next)):
                curr = next
                value = k
                result += 1 # 이동
                break
    
    return result
                

def check(k,d):
    return d >= (k)*(k-1)//2

T = int(input())
for _ in range(T):
    a, b = map(int,input().split())
    print(calc(b-a))