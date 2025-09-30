import sys
input = sys.stdin.readline

def getCount(num):
    cnt = 0
    m = num
    n = 0
    while(m > 0):
        m//=2 # 이진수 길이만큼
        n+=1
        start = num - 2**(n-1) # 1 첫 등장
        size = 2**(n-1)
        cycle = num//2**n # 1 등장 사이클

        remains = num%(2**n) # 남는 구간
        cnt += (num-remains)//2
        cnt += max(0, remains-size+1)

    return cnt


A, B = map(int,input().split())

print(getCount(B)-getCount(A-1))