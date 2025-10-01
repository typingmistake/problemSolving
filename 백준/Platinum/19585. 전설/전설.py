import sys
input = sys.stdin.readline

class trie:
    def __init__(self):
        self.head = {} # 맵으로 자식 연결
        self.names = set()

    def add_color(self, color):
        curr = self.head
        for i in range(len(color)):
            if(color[i] not in curr):
                curr[color[i]] = {}
            curr = curr[color[i]]
        
        curr[-1] = True # 끝을 표시
    
    def isValid(self, team_name):
        idx = 0
        curr = self.head

        while(idx < len(team_name)):
            if -1 in curr and team_name[idx:] in self.names:
                return True
            
            if(team_name[idx] not in curr):
                return False

            curr = curr[team_name[idx]]
            idx+=1
        
        return False

    def add_name(self, name):
        self.names.add(name)


C, N = map(int, input().split())
t = trie()

for _ in range(C):
    t.add_color(input().strip())

for _ in range(N):
    t.add_name(input().strip())

Q = int(input())

for _ in range(Q):
    team_name = input().strip()
    if(t.isValid(team_name)):
        print("Yes")
        continue

    print("No")