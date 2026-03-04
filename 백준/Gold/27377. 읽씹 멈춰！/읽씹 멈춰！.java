import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            String[] input = br.readLine().split(" ");
            long s = Long.parseLong(input[0]);
            long t = Long.parseLong(input[1]);

            long cost = 0;

            while (N > 0) {
                if (N % 2 == 1) {
                    cost += s;
                    N--;
                } else {
                    long m = (N/2 <= t/s) ? s*N/2 : t;
                    cost += m;
                    N /= 2;
                }
            }

            System.out.println(cost);
        }
    }
}