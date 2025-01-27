import sys
input = sys.stdin.readline
vowels = ['a', 'e', 'i', 'o', 'u']

def solve(pw, vowels):
    if not any( vowel in pw for vowel in vowels):
        return False
    
    v_cnt = 0
    c_cnt = 0
    for letter in pw:
        if letter in vowels:
            v_cnt += 1
            c_cnt = 0
        else:
            c_cnt += 1
            v_cnt = 0
        
        if v_cnt == 3 or c_cnt == 3:
            return False
    
    for idx in range(1,len(pw)):
        if(pw[idx] == pw[idx-1] and pw[idx] != 'o' and pw[idx] != 'e'):
            return False
    
    return True
    


pw = input().strip()

while(pw != 'end'):
    if solve(pw, vowels):
        print(f'<{pw}> is acceptable.')
    else:
        print(f'<{pw}> is not acceptable.')
    
    pw = input().strip()