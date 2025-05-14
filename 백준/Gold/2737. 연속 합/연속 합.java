import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().strip());

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine().strip());
            bw.write(String.valueOf(calc(N)));
            bw.newLine();
        }

        bw.flush();
    }

    public static int calc(long N) {
        long M = 2;
        int res = 0;
        while (true) {
            double a = (double) N / M - (M - 1) / 2.0;

            if (a < 1)
                break;

            if (Math.abs(a - Math.round(a)) < 1e-10) {
                res++;
            }
            M++;
        }
        return res;
    }
}