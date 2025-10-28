import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[][] dp = new int[N + 1][K + 1]; // dp[i][j] = j개를 더해서 i를 만드는 경우의 수
        dp[0][0] = 1;

        // k개의 수 사용
        for(int i = 1; i <= K; i++){
            // 출발점
            for(int j = 0; j <= N; j++){
                // 이번에 더할 수 k
                for(int k = 0; k <= N; k++){
                    if(j + k > N) break;
                    dp[j + k][i] += dp[j][i-1];
                    dp[j + k][i] %= MOD;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}