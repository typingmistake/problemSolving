import java.util.*;

class Solution {
    static int mod = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        Set<Integer> set = new HashSet<>();
        
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1; // 집은 물에 잠기지 않음

        for (int[] puddle : puddles) {
            set.add(puddle[1] * 1000 + puddle[0]); // 1000 * y + x
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i==1 && j==1)
                    continue;
                
                if (set.contains(i * 1000 + j))
                    continue;

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
        return dp[n][m];
    }
}