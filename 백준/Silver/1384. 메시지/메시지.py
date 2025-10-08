import sys
input = sys.stdin.readline

num = 0

while(True):
    n = int(input())

    if(n==0):
        break

    num+=1
    if(num > 1): print("")
    print("Group " + str(num))

    names = [-1]*n
    bads = []
    
    for i in range(n):
        names[i], *msgs = input().split()
        for j in range(len(msgs)):
            if(msgs[j] == 'N'):
                bads.append([(i-(j+1))%n, i])
    
    if(not bads):
        print("Nobody was nasty")
        continue

    for bad in bads:
        print(f'{names[bad[0]]} was nasty about {names[bad[1]]}')