import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        long S = Long.parseLong(line[1]);
        int P = Integer.parseInt(line[2]);

        if(N==0){
            System.out.println(1);
            return;
        }

        Long[] nums = new Long[N+1];
        line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(line[i]);
        }

        nums[N] = S;

        Arrays.sort(nums, (a,b) -> Long.compare(b,a));

        int res = 0;
        long prev = -1;
        int cnt = 1; // 현재 동점 리스트

        // 0 <= N <= P
        for(int i = 0; i < P; i++){
            long curr = nums[i];

            // 현재 등수 업데이트
            if(curr != prev) {
                prev = curr;
                res += cnt;
                cnt = 0;
            }
            cnt++;

            if(curr == S && (i+1 == N+1 || nums[i+1] != S)){
                System.out.println(res);
                return;
            }
        }

        System.out.println(-1);
    }
}