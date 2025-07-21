class Solution {
    int MOD = 1234567;
    public long solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i = 0; i < n; i++){
            int[] nexts = new int[]{i+1,i+2};
            
            for(int next : nexts){
                if(next <= n)
                    dp[next] = (dp[next] + dp[i])%MOD;
            }
        }
        
        return dp[n];
    }
}