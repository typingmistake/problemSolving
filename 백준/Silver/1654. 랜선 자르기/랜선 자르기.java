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
        long[] arr = new long[N];

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        System.out.println(solve(arr, K, N));
    }
    public static long solve(long[] arr, int K, int N){
        long start = 1L;
        long end = 0;
        for(int i = 0; i < N; i++){
            end = Math.max(end, arr[i]);
        }

        while(start <= end){
            long pivot = (start + end) / 2;

            if(getCnt(arr, pivot) < K){
                end = pivot-1; // end는 최대한 보존
            } else{
                start = pivot+1;
            }
        }
        return end;
    }
    public static long getCnt(long[] arr, long div){
        long result = 0;

        for(long num : arr){
            result += (num/div);
        }

        return result;
    }

}