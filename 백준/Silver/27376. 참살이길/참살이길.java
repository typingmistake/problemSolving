import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        long prev = 0; // 이전 위치
        long curr = 0; // 현재 시간
        int[][] signal = new int[K][3];

        while(K-- > 0){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int t = Integer.parseInt(line[1]);
            int s = Integer.parseInt(line[2]);

            signal[K] = new int[]{x, t, s};
        }

        Arrays.sort(signal, (a,b)->a[0]-b[0]);

        for(int[] sig : signal) {
            int x = sig[0];
            int t = sig[1];
            int s = sig[2];

            curr += x - prev; // 신호등 위치까지 이동 시간
            prev = x;

            if(curr < s) curr = s;

            // 도착했을 때 빨간 불
            if (((curr-s) / t) % 2 == 1) {
                curr += t - (curr-s) % t;
            }
        }

        curr += N - prev; // 마지막 위치까지 이동 시간

        System.out.println(curr);
    }
}