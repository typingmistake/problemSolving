class Solution {
    public int solution(int n, int[] tops) {
        int len = 2 * n + 1; // 아래 타일 개수
        int[] dp = new int[len + 1];
        int mod = 10_007;
        dp[0] = 1;

        for (int i = 0; i < len; i++) {
            // 안채우고 넘어가는 경우
            dp[i + 1] = (dp[i + 1] + dp[i]) % mod;

            // 위에 정삼각형을 채우는 경우
            if (i % 2 == 1 && tops[i / 2] == 1) {
                dp[(i + 1)] = (dp[i + 1] + dp[i]) % mod;
            }

            // 사다리꼴을 채우는 경우
            if (i != len - 1) {
                dp[i + 2] = (dp[i + 2] + dp[i]) % mod;
            }
        }

        return dp[len];

    }
}