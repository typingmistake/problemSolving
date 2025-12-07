import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[][] input = new long[M][N + 1];
            long L = 1; // 최소공배수

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i <= N; i++) {
                    input[j][i] = Long.parseLong(st.nextToken());
                }
                L = L*input[j][0] / gcd(L, input[j][0]);
            }

            long[] score = new long[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    score[i] += input[j][i + 1] * (L / input[j][0]);
                }
            }

            Arrays.sort(score);
            long b = score[N - 1] - score[0];
            long a = L;

            if (b == 0) {
                System.out.println(0);
                continue;
            }

            long g = gcd(a, b);
            System.out.println(a / g == 1 ? b / g : (b / g) + "/" + (a / g));
        }
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}