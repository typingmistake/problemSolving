import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 무게추
        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 구슬

        int MAX = 40000;
        char[] dp = new char[MAX+1];
        Arrays.fill(dp, 'N');
        dp[0] = 'Y'; // 0은 항상 측정 가능

        for(int w : weight){
            // 반대쪽 저울에 추가
            for(int i = MAX-w; i >= 0; i--){
                if(dp[i] == 'Y') dp[i+w] = 'Y';
            }
        }

        for(int w : weight){
            // 구슬쪽 저울에 추가
            for(int i = w; i <= MAX; i++){
                if(dp[i] == 'Y') dp[i-w] = 'Y';
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M-1; i++){
            sb.append(dp[nums[i]]).append(" ");
        }
        sb.append(dp[nums[M-1]]);

        System.out.println(sb);
    }
}