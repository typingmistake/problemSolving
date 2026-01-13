import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long k = Long.parseLong(input[0]);
        long a = Long.parseLong(input[1]);
        long b = Long.parseLong(input[2]);

        long result = calc(a, b, k);

        System.out.println(result);
    }

    public static long calc(long a, long b, long k){
        if(a <= 0 && 0 <= b) {
            return 1 + Math.abs(a)/k + Math.abs(b)/k;
        }
        if(0 < a){
            return b/k - (a-1)/k;
        }
        return Math.abs(a)/k - Math.abs(b+1)/k;
    }
}