import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    ta,tb,va,vb = map(int,input().split())

    ct = tb*vb # B테스트 완료 시간 -> 15

    if(ct >= ta*va):
        print(ct)
        continue

    ca = ct//ta + 1 # A 현재 완료 -> 6

    if(va-ca)%2 == 0:
        print((ca + (va-ca)//2)*ta)
    else:
        print(ct + ta*((va-ca)//2+1))