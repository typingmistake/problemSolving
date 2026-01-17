import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnts = new int[21]; // 2^20 = 1_048_576 > 1_000_000
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            int bit = 0;
            while((1 << bit) <= num){
                if((num & (1 << bit)) != 0){
                    cnts[bit]++;
                }
                bit++;
            }
        }

        long result = 0;
        for(int i = 0; i <= 20; i++){
            result += (long) cnts[i] * (N - cnts[i]) * (1L << i);
        }

        System.out.println(result);
    }
}