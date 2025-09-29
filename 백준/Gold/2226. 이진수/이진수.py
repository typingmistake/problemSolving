import sys
input = sys.stdin.readline

SIZE = 1001

dp1 = [0]*SIZE # 1에서 시작
dp2 = [0]*SIZE # 0에서 시작
dp1[1] = 0
dp2[1] = 1

for i in range(2, SIZE):
    dp1[i] = dp1[i-1] + dp2[i-1]
    dp2[i] = dp1[i-1] + dp2[i-1]

    if(i%2==1):
        dp1[i] -= 1


N = int(input())
print(dp1[N])