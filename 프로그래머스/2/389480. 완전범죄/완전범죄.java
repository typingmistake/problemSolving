
import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[3 * info.length + 1]; // B의 증거마다 A의 증거 메모이제이션
        Arrays.fill(dp, 3 * info.length);
        int sumB = Arrays.stream(info).mapToInt(x -> x[1]).sum();
        dp[sumB] = 0;

        for (int i = 0; i < info.length; i++) {
            int[] curr = info[i];
            int currA = curr[0];
            int currB = curr[1];

            for (int j = 0; j <= sumB - currB; j++) {
                dp[j] = Math.min(dp[j], dp[j + currB] + currA);
            }
        }

        int answer = Arrays.stream(dp).limit(m).min().getAsInt();

        return answer < n ? answer : -1;
    }
}