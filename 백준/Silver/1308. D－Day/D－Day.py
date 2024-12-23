import sys
input = sys.stdin.readline

months = [31,28,31,30,31,30,31,31,30,31,30,31]
leaf_months = [31,29,31,30,31,30,31,31,30,31,30,31]

def is_leap(Y):
    if Y%4 == 0:
        if Y%100 == 0:
            if Y%400 == 0:
                return True
            return False
        return True
    return False

def calcDay(year,month,day):
    ans = day
    for y in range(1,year):
        if is_leap(y):
            ans += 366
        else:
            ans += 365
    
    if is_leap(year):
        for m in range(month-1):
            ans += leaf_months[m]
    else:
        for m in range(month-1):
            ans += months[m]
    
    return ans
    

def solve(curr, end):
    [curr_y, curr_m, curr_d] = curr
    [end_y,end_m,end_d] = end

    if(end_y-curr_y > 1000):
        return 'gg'
    
    if(end_y-curr_y == 1000):
        if(end_m==curr_m and end_d>=curr_d):
            return 'gg'
        elif(end_m>curr_m):
            return 'gg'
    
    calc_curr = calcDay(curr_y, curr_m, curr_d)
    calc_end = calcDay(end_y, end_m, end_d)
    diff = calc_end - calc_curr

    return f'D-{diff}'


curr = list(map(int,input().split()))
end = list(map(int,input().split()))

print(solve(curr,end))


    