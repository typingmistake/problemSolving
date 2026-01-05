import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] max = new int[N];
            int curr = 0;

            for(int i = N-1; i >= 0; i--){
                curr = Math.max(curr, arr[i]);
                max[i] = curr;
            }

            long res = 0;
            for(int i = 0; i < N; i++){
                res += (max[i] - arr[i]);
            }

            System.out.println(res);
        }

    }
}