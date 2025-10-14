import sys
input = sys.stdin.readline

S = input().strip()

ans = [0,0]
target = ['0', '1']

for j in range(2):
    changing = False
    for i in range(len(S)):
        if(S[i] == target[j]):
            changing = False
            continue

        if(changing):
            continue

        changing = True
        ans[j] += 1

print(min(ans))
