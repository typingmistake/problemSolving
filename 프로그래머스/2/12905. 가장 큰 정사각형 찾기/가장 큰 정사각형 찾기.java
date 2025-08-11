class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int r = board.length, c = board[0].length;
        int[][] dp = new int[r][c];
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] != 1){
                    continue;
                }
                
                if(i != 0 && j != 0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                } else {
                    dp[i][j] = board[i][j] == 1 ? 1 : 0;
                }
                
                answer = Math.max(answer, dp[i][j] * dp[i][j]);
            }
        }

        return answer;
    }
}