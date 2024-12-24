import sys
input = sys.stdin.readline

def checkLeaf(year):
    if year%4==0:
        if year%100==0:
            if year%400==0:
                return True
            return False
        return True
    return False

months = {
    'January':1,
    'February':2,
    'March':3,
    'April':4,
    'May':5,
    'June':6,
    'July':7, 
    'August':8,
    'September' :9,
    'October':10, 
    'November':11,
    'December':12 
}

def convertTime(T):
    time, min = T.split(':')
    return int(time), int(min)

days = [0,31,28,31,30,31,30,31,31,30,31,30,31]
leaf_days = [0,31,29,31,30,31,30,31,31,30,31,30,31]

def solve(year,month,day,time,min):
    if checkLeaf(year):
        sum = 366*24*60
        curr = (day-1)*24*60+time*60+min
        for m in range(1,month):
            curr+=leaf_days[m]*24*60
    else:
        sum = 365*24*60
        curr = (day-1)*24*60+time*60+min
        for m in range(1,month):
            curr+=days[m]*24*60

    print(100*curr/sum)


    
M, D, Y, T = input().split()
m = months[M]
t,min = convertTime(T)
d,y = int(D.replace(',','')), int(Y)

solve(y,m,d,t,min)