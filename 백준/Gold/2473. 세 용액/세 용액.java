import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        long[] nums = Arrays.stream(sc.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        
        Arrays.sort(nums);

        long[] answer = new long[3];
        long result = Long.MAX_VALUE;

        for(int i = 0; i < N; i++){
            long[] curr = solve(nums, i);
            long num = Math.abs(curr[0] + curr[1] + curr[2]);

            if(num < result){
                result = num;
                answer = curr;
            }
        }

        Arrays.sort(answer);
        System.out.println(String
                .join(" ", Arrays.stream(answer)
                        .mapToObj(String::valueOf).toArray(String[]::new)));
    }
    public static long[] solve(long[] nums, int a){
        long result = Long.MAX_VALUE;
        int startIdx = 0, endIdx = nums.length-1;
        long[] curr = new long[3];

        while(startIdx < endIdx){
            if(startIdx == a){
                startIdx++;
                continue;
            }
            if(endIdx == a){
                endIdx--;
                continue;
            }

            long sum = nums[startIdx] + nums[endIdx] + nums[a];

            if(abs(sum) < result){
                curr = new long[]{nums[startIdx], nums[endIdx], nums[a]};
                result = abs(sum);
            }

            if(sum > 0) {
                endIdx--;
                continue;
            }
            startIdx++;
        }

        return curr;
    }
}