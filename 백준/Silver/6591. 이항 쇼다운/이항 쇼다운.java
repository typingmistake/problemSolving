import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            if (n == 0 && k == 0) break;

            System.out.println(solve(n, k));
        }

    }
    public static long solve(int n, int k) {
        long result = 1;

        k = Math.max(k, n-k);

        for (int i = n; i > k; i--) {
            result = result * i;
            result = result / (n-i+1);
        }

        return result;
    }
}