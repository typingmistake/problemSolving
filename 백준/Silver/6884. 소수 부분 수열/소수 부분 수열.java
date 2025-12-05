import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] isPrime = getPrimes(10_000 * 10_000);

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i + 1]);
            int first = arr[0];
            List<Integer> result = new ArrayList<>();

            for(int len = 2; len <= N; len++) {
                first += arr[len - 1]; // 현재 첫번째 구간 합
                int sum = first;

                if(isPrime[sum]) {
                    for(int j = 0; j < len; j++) {
                        result.add(arr[j]);
                    }
                    break;
                }

                // 슬라이딩 윈도우
                for(int i = 1; i < N-len+1; i++) {
                    sum -= arr[i - 1];
                    sum += arr[i + len - 1];

                    if(!isPrime[sum]) continue;

                    for(int j = i; j < i + len; j++) {
                        result.add(arr[j]);
                    }

                    break;
                }

                if(!result.isEmpty()) break;
            }

            if(result.isEmpty()){
                System.out.println("This sequence is anti-primed.");
                continue;
            }

            System.out.print("Shortest primed subsequence is length " + result.size() + ":");
            for(int num : result) System.out.print(" " + num);
            System.out.println();
        }
    }
    public static boolean[] getPrimes(int max){
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i * i <= max; i++) {
            if(!isPrime[i]) continue;
            for(int j = i*i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}