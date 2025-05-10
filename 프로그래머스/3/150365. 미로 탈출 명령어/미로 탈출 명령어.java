class Solution {
    int n, m, r, c, k;
    int[] dr = { 1, 0, 0, -1 };
    int[] dc = { 0, -1, 1, 0 };
    String[] dir = { "d", "l", "r", "u" };
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        String answer = dfs("", x, y, 0);
        return answer.equals("") ? "impossible" : answer;
    }
    
    public String dfs(String path, int curr_r, int curr_c, int count) {
        if (curr_r == r && curr_c == c && count == k) {
            return path;
        }
        
        // 가지 치기 1
        if(count == k){
            return "";
        }
        
        // 가지 치기 2
        if (Math.abs(curr_r - r) + Math.abs(curr_c - c) > k - count) {
            return "";
        }
        
        // 가지 치기 3
        if ((Math.abs(curr_r - r) + Math.abs(curr_c - c)) % 2 != (k - count) % 2) {
            return "";
        }
        
        for (int i = 0; i < 4; i++) {
            int next_r = curr_r + dr[i];
            int next_c = curr_c + dc[i];

            if (next_r < 1 || next_r > n || next_c < 1 || next_c > m) {
                continue;
            }
            
            String result = dfs(path + dir[i], next_r, next_c, count + 1);
            if (!result.equals("")) {
                return result;
            }
        }
        
        return "";
    }
}