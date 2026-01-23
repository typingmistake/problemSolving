import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[][] dp = new long[30][31];
        dp[0][0] = 1;

        for(int i = 1; i < 30; i++){
            dp[i][0] = dp[i-1][0];
            for(int j = 1; j <= i; j++){
                dp[i][j] += dp[i-1][j] + dp[i-1][j-1];
            }
        }
        int[][] arr = new int[M][2];
        for(int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        long result = 1;
        int[] curr = new int[]{0, 0};

        for(int i = 0; i < M; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            if(b-curr[1] < 0){
                System.out.println(0);
                return;
            }
            result *= dp[a-curr[0]][b-curr[1]];
            curr = new int[]{a, b};
        }
        result *= (long)Math.pow(2, N-1-curr[0]);
        System.out.println(result);
    }
}