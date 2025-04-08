import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>() {
        {
            put("diamond", 0);
            put("iron", 1);
            put("stone", 2);
        }
    };

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int n = minerals.length;
        int[] mines = new int[3];
        int[] use = new int[3];
        for (int i = 0; i < 3; i++) {
            use[i] = picks[i] * 5;
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String mineral = minerals[i];
            if (map.containsKey(mineral)) {
                mines[map.get(mineral)]++;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (dp[i][j] == Integer.MAX_VALUE)
                    continue;
                if (i < n && j < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + mines[0]);
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + mines[1]);
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + mines[2]);
                }
            }
        }

        return dp[n][n];
    }
}