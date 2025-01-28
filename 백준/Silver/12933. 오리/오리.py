import sys
input = sys.stdin.readline

sound = input().strip()

threads = []
prevs = {
    'q': 'k',
    'u': 'q',
    'a': 'u',
    'c': 'a',
    'k': 'c',
}

def solve(sound):
    threads = []
    for s in sound:
        prev = prevs[s]
        appended = False

        for i in range(len(threads)):
            t = threads[i]
            if(t[-1] == prev):
                threads[i] += s
                appended = True
                break
        
        if(not appended):
            if(s == 'q'):
                threads.append(s)
            else:
                return -1
                
    
    for t in threads:
        if t[-1] != 'k':
            return -1
        
    return len(threads)


print(solve(sound))

    
