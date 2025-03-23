class Solution {
    public int solution(int n, int m, int[] section) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < section.length; i++) {
            dp[section[i]] = 1;
        }

        int idx = 1;
        int cnt = 0;

        while (idx <= n) {
            if (dp[idx] == 1) {
                cnt++;
                for (int i = 0; i < m; i++) {
                    dp[(idx + i) % (n + 1)] = 0;
                }
                idx+=(m-1);
            }
            idx++;
        }

        return cnt;

    }
}