import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;

        for(int i = 0; i < N; i++){
            result += calc(i+1, arr[i]);
        }

        System.out.println(result);

    }
    public static long calc(int a, int b){
        return Math.abs(a - b);
    }
}