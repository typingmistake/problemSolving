class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int HOUR = 24;
        int[] dp = new int[HOUR];
        for (int h = 0; h < HOUR; h++) {
            int min_server = players[h] / m;

            if (dp[h] < min_server) {
                int diff = (min_server - dp[h]);
                answer += diff;
                for (int i = 0; i < k; i++) {
                    dp[(h + i)%HOUR] += diff;
                }
            }
        }
        return answer;
    }
}