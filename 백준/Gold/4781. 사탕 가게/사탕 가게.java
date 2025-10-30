import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = (int) (Double.parseDouble(line[1]) * 100.0 + 0.5);
            if (N == 0) {
                break;
            }

            long[] dp = new long[M+1]; // dp[i] = i원을 사용해서 얻은 최대 칼로리

            while(N-- > 0){
                line = br.readLine().split(" ");
                long c = Long.parseLong(line[0]);
                int p = (int) (Double.parseDouble(line[1]) * 100.0 + 0.5);

                for(int i = 0; i <= M-p; i++){
                    if(dp[i+p] < dp[i] + c){
                        dp[i+p] = dp[i] + c;
                    }
                }
            }

            System.out.println(Arrays.stream(dp).max().orElse(0));
        }


    }
}