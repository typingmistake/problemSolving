import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        while(M-- > 0){
            String[] nums = br.readLine().split(" ");
            int[] arr = new int[N];
            int minCnt = 0; // 음수 개수
            long num = 1; // 현재까지 곱해진 수
            int cnt = 0; // 곱해진 수의 개수
            int min = Integer.MAX_VALUE; // 음수 중 절댓값이 가장 작은 수
            boolean hasZero = false; // 0 존재 여부

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(nums[i]);
                if(arr[i] < 0){
                    minCnt++;
                    if(Math.abs(arr[i]) < Math.abs(min)) min = arr[i];
                }
                if(Math.abs(arr[i]) > 0){
                    num *= arr[i];
                    cnt++;
                }
                if(arr[i] == 0) hasZero = true;
            }

            if(minCnt%2 == 1){
                num /= min;
                cnt--;
            }

            if(cnt == 0){
                if(hasZero) System.out.println(0);
                else System.out.println(min); // 음수 하나만 있는 경우
            }
            else System.out.println(num);
        }
    }
}