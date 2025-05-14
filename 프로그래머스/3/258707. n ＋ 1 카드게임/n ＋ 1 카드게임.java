
import java.util.Arrays;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int n = cards.length; // 6의 배수
        int[] dp = new int[coin + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin; j >= cards[i]; j--) {
                if (dp[j - cards[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - cards[i]] + 1);
                }
            }
        }

        for (int i = coin; i >= 0; i--) {
            if (dp[i] != Integer.MAX_VALUE) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
}