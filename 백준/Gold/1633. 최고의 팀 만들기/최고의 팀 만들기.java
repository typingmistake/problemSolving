import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        List<int[]> players = new ArrayList<>();

        while (sc.hasNextInt()) {
            int w = sc.nextInt();
            int b = sc.nextInt();
            players.add(new int[]{w, b});
        }

        int N = players.size();
        int[][][] dp = new int[N+1][17][17]; // i번째 까지 고려, j명의 백, k명의 흑

        for(int i = 1; i <= N; i++){
            int[] p = players.get(i-1);
            int w = p[0];
            int b = p[1];
            for(int j = 0; j < 16; j++){
                for(int k = 0; k < 16; k++){
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
                    dp[i][j+1][k] = Math.max(dp[i][j+1][k], dp[i-1][j][k] + w);
                    dp[i][j][k+1] = Math.max(dp[i][j][k+1], dp[i-1][j][k] + b);
                }
            }
        }

        System.out.println(dp[N][15][15]);
    }
}