import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Double[] arr = new Double[N];

        for(int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        Double result = 0.0;
        for(int i = K; i < N - K; i++){
            result += arr[i];
        }

        System.out.println(String.format("%.2f", result / (N - 2 * K)));

        for(int i = 0; i < K; i++){
            arr[i] = arr[K];
        }

        for(int i = N - K; i < N; i++){
            arr[i] = arr[N - K - 1];
        }

        result = 0.0;
        for(int i = 0; i < N; i++){
            result += arr[i];
        }

        System.out.println(String.format("%.2f", result / N));

    }
}