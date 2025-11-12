import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().strip();
        String target = br.readLine().strip();

        int N = str.length();
        int M = target.length();

        int[][] dp = new int[N+1][M+1]; // dp[i][j] : str i -> target j 변환 비용

        for(int i = 1; i <= N; i++){
            dp[i][0] = i; // 삭제
        }

        for(int j = 1; j <= M; j++){
            dp[0][j] = j; // 추가
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(str.charAt(i-1) == target.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // 그대로 사용
                }else{
                    int min = dp[i-1][j-1]+1; // 추가
                    min = Math.min(min, dp[i][j-1]+1); // 삭제
                    min = Math.min(min, dp[i-1][j]+1); // 교체
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
