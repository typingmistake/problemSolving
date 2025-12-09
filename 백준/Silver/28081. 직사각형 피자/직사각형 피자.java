import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int W = Integer.parseInt(input[0]);
        int H = Integer.parseInt(input[1]);
        long K = Long.parseLong(input[2]);

        int N = Integer.parseInt(br.readLine()) + 1;
        long[] xArr = new long[N];
        String[] xInput = br.readLine().split(" ");
        int prev = 0;

        for (int i = 0; i < N - 1; i++) {
            int curr = Integer.parseInt(xInput[i]);
            xArr[i] = curr - prev;
            prev = curr;
        }
        xArr[N - 1] = H - prev;

        int M = Integer.parseInt(br.readLine()) + 1;
        long[] yArr = new long[M];
        String[] yInput = br.readLine().split(" ");
        prev = 0;

        for (int i = 0; i < M - 1; i++) {
            int curr = Integer.parseInt(yInput[i]);
            yArr[i] = curr - prev;
            prev = curr;
        }
        yArr[M - 1] = W - prev;

        Arrays.sort(yArr);  // y 오름차순 정렬

        long ans = 0;

        for (int i = 0; i < N; i++) {
            long limit = K / xArr[i];
            ans += binarySearch(yArr, limit);
        }

        System.out.println(ans);
    }

    static long binarySearch(long[] arr, long limit) {
        int start = 0;
        int end = arr.length;

        while(start < end){
            int pivot = (start + end) / 2;
            if(arr[pivot] > limit) {
                end = pivot;
                continue;
            }
            start = pivot+1;
        }
        return end;
    }
}