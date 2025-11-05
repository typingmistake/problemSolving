import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;

        if(N == 1){
            System.out.println(dp[N]);
            return;
        }

        dp[2] = 5;

        if(N == 2){
            System.out.println(dp[N]);
            return;
        }

        for(int i = 3; i <= N; i++){
            dp[i] = 3*dp[i-1] - 3*dp[i-2] + dp[i-3] + (i % 2 == 0 ? 2 : 1);
        }

        System.out.println(dp[N]);
    }
}