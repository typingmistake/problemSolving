import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        long N = calcN(x + y);

        if(N == -1){
            System.out.println(-1);
            return;
        }

        int cnt = 0;

        for(long i = N; i > 0; i--){
            if(x >= i){
                x -= i;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static long calcN(long sum){
        long left = 1;
        long right = (long)Math.sqrt(2 * sum) + 1;
        while(left <= right){
            long n = (left + right) / 2;
            long currSum = n*(n+1)/2;

            if(currSum == sum) return n;
            else if(currSum < sum) left = n + 1;
            else right = n - 1;
        }

        return -1;
    }
}