import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int[] dp = new int[10_001];
        dp[0] = 1;

        for(int i = 1; i <= 10_000; i++){
            int n = i;

            while(n%10 == 0){
                n /= 10;
            }

            dp[i] = dp[i-1] * n;

            while(dp[i]%10 == 0){
                dp[i] /= 10;
            }

            dp[i] %= 100_000;
        }
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            System.out.println(String.format("%5d -> %d", N, dp[N]%10));
        }
    }
}
