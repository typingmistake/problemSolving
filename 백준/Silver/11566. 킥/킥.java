import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = -1;
        int min = Integer.MAX_VALUE;
        int gap = 1;

        while((N-1)*gap < M){
            for(int i = 0; i + (N-1)*gap < M; i++) {
                boolean flag = true;

                for (int j = 0; j < N; j++) {
                    if (arr[j] != nums[i + j * gap]) {
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    max = Math.max(max, gap-1);
                    min = Math.min(min, gap-1);
                    break;
                }
            }
            gap++;
        }


        System.out.println(max == -1 && min == Integer.MAX_VALUE ? -1 : min + " " + max);
    }
}