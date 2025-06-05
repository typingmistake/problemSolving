import java.util.Arrays;

class Solution {
    static int mod = 1_000_000_007;

    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int m : money){
            for(int i = 0; i <= n-m; i++){
                dp[i+m] = (dp[i+m] + dp[i])%mod;
            }
        }
        return dp[n];
    }

    
}