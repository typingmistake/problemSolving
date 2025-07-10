class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] diff = new int[n+1][m+1];
        
        for(int[] s : skill){
            addDiff(diff, s);
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                diff[i][j] = diff[i-1][j] + diff[i][j];
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                diff[j][i] = diff[j][i-1] + diff[j][i];
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] + diff[i][j] > 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    public void addDiff(int[][] diff, int[] s){
        int value = s[0] == 1 ? -s[5] : s[5];
        diff[s[1]][s[2]] += value;
        diff[s[3]+1][s[2]] -= value;
        diff[s[1]][s[4]+1] -= value;
        diff[s[3]+1][s[4]+1] += value;
    }
}