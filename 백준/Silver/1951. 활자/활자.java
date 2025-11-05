import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MOD = 1_234_567;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long ans = 0;
        while(true){
            int len = String.valueOf(N).length();
            if(len == 1){
                ans += N;
                ans %= MOD;
                break;
            }
            long next = (long) Math.pow(10, len - 1) - 1;
            ans += (N-next) * len;
            ans %= MOD;
            N = next;
        }

        System.out.println(ans);
    }
}