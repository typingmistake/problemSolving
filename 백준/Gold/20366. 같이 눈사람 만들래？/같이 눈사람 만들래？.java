import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[] arr = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr); // 오름차순 정렬
        int answer = Integer.MAX_VALUE;

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                int target = arr[i] + arr[j];
                answer = Math.min(answer, solve(arr, j, i, target));
            }
        }

        System.out.println(answer);
    }

    public static int solve(int[] arr, int a, int b, int target){
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            if(start == a || start == b){
                start++;
                continue;
            }
            if(end == b || end == a){
                end--;
                continue;
            }

            int sum = arr[start] + arr[end];
            int diff = Math.abs(target - sum);
            res = Math.min(res, diff);

            if(sum < target){
                start++;
            } else {
                end--;
            }
        }

        return res;
    }
}