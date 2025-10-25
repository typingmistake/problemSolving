import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(sc.readLine());
        int[] nums = Arrays.stream(sc.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        Long ans = 0L;

        if(N == 1){
            Arrays.sort(nums);
            for(int i=0; i<5; i++){
                ans += nums[i];
            }
            System.out.println(ans);
            return;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        // 1면 최소값
        for(int i=0; i<6; i++){
            min1 = Math.min(min1, nums[i]);
            for(int j=i+1; j<6; j++){
                // 2면 최소값
                if(i + j == 5) continue; // 마주보는 면 제외
                min2 = Math.min(min2, nums[i] + nums[j]);
                for(int k=j+1; k<6; k++){
                    // 3면 최소값
                    if(i + k == 5 || j + k == 5) continue; // 마주보는 면 제외
                    min3 = Math.min(min3, nums[i] + nums[j] + nums[k]);
                }
            }
        }

        ans += min3 * 4L; // 3면
        ans += min2 * (4L * (N-1) + 4L * (N-2)); // 2면
        ans += min1 * ((N-2)*(N-2) + (N-2)*(N-1)*4L); // 1면

        System.out.println(ans);
    }
}
