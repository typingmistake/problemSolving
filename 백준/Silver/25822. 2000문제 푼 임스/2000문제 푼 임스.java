import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double c = Double.parseDouble(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int cnt = (int)(c / 0.99);
        cnt = Math.min(cnt, 2);
        int[][] dp = new int[N][cnt+2];

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(arr).max().orElse(0);
        int maxCnt = 1;

        if(arr[0] == 0) dp[0][1] = 1;
        else dp[0][0] = 1;

        for(int i = 1; i < N; i++){
            if(arr[i] == 0){
                for(int j = 1; j <= cnt; j++){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxCnt = Math.max(maxCnt, dp[i][j]);
                }
            }else{
                for(int j = 0; j <= cnt; j++){
                    dp[i][j] = dp[i-1][j] + 1;
                    maxCnt = Math.max(maxCnt, dp[i][j]);
                }
            }
        }

        System.out.println(maxCnt);
        System.out.println(max);
    }
}