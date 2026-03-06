import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());
        System.out.println(search(arr, 0, max, M));
    }
    public static int search(int[] arr, int start, int end, int m){
        while(start <= end){
            int pivot = (start + end)/2;

            if(check(arr, pivot, m)){
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
        return end;
    }
    public static boolean check(int[] arr, int p, int m){
        for(int n : arr){
            m -= Math.min(n, p);
        }
        return m >= 0;
    }
}