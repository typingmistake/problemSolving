import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] dp = new long[N];

        for(int i = N-2; i >= 0; i--){
            dp[i] = Long.MAX_VALUE;
            for(int j = i+1; j < N; j++){
                dp[i] = Math.min(dp[i], Math.max(dp[j], calc(arr, i, j)));
            }
        }

        System.out.println(dp[0]);
    }

    public static long calc(int[] arr, int from, int to){
        return (long)(to - from) * (1 + Math.abs(arr[from] - arr[to]));
    }
}