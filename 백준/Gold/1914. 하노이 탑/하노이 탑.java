import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE)); // 2^N - 1

        if(N > 20) return;

        solve(N, 1, 3, 2);
    }

    public static void solve(int N, int from, int to, int mid){
        if(N == 1){
            System.out.println(from + " " + to);
            return;
        }

        solve(N-1, from, mid, to);
        solve(1, from, to, mid);
        solve(N-1, mid, to, from);
    }
}