import sys
input = sys.stdin.readline


def find(parents, f):
    if(parents[f] != f):
        parents[f] = find(parents, parents[f])
    return parents[f]

T = int(input())

for i in range(T):
    parents = {}
    cnt = {}
    F = int(input())

    for j in range(F):
        f1, f2 = input().strip().split()

        if f1 not in parents:
            parents[f1] = f1
            cnt[f1] = 1
        if f2 not in parents:
            parents[f2] = f2
            cnt[f2] = 1

        p1, p2 = find(parents, f1), find(parents, f2)

        if(p1 != p2):
            parents[p2] = p1
            cnt[p1] += cnt[p2]
        
        print(cnt[p1])