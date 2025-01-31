import sys
input = sys.stdin.readline

def toString(num):
    if num%3==0 and num%5==0:
        return "FizzBuzz"
    if num%3==0:
        return "Fizz"
    if num%5==0:
        return "Buzz"
    
    return str(num)

def solve(a,b,c):
    if(a.isdigit()):
        return toString(int(a)+3)
    if(b.isdigit()):
        return toString(int(b)+2)
    if(c.isdigit()):
        return toString(int(c)+1)
    

a = input().strip()
b = input().strip()
c = input().strip()

print(solve(a,b,c))