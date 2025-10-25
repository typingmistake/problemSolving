import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[] nums = Arrays.stream(sc.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int idx = -1;
        int maxVal = -1;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                idx = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (idx >= 0) {
            if(dp[idx] == maxVal) {
                result.add(nums[idx]);
                maxVal -= 1;
            }
            idx -= 1;
        }

        System.out.println(result.size());
        Collections.reverse(result);
        System.out.println(result.stream()
                                .map(String::valueOf)
                                .reduce((a, b) -> a + " " + b)
                                .orElse("") );
    }
}
