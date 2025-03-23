import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] baggages = new int[N][2];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            baggages[i][0] = Integer.parseInt(input[0]);
            baggages[i][1] = Integer.parseInt(input[1]);
        }

        int ans = solve(N, K, baggages);

        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
    }

    public static int solve(int N, int K, int[][] baggages) {
        int[] dp = new int[K + 1];
        for (int i = 0; i < N; i++) {
            int w = baggages[i][0];
            int v = baggages[i][1];
            for (int j = K - w; j >= 0; j--) {
                dp[j + w] = Math.max(dp[j + w], dp[j] + v);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}