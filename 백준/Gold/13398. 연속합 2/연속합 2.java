import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = solve(N, nums);

        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
    }

    public static int solve(int N, int[] nums) {
        int[] dp_right = Arrays.copyOf(nums, N);
        int[] dp_left = Arrays.copyOf(nums, N);

        // N이 1인 경우
        if (N == 1) {
            return nums[0];
        }

        // i번째에서 끝나는 최대 부분합
        for (int i = 1; i < N; i++) {
            dp_left[i] = Math.max(dp_left[i - 1] + nums[i], nums[i]);
        }

        // i번째에서 시작하는 최대 부분합
        for (int i = N - 2; i >= 0; i--) {
            dp_right[i] = Math.max(dp_right[i + 1] + nums[i], nums[i]);
        }

        // 첫번째, 마지막 원소를 삭제하는 경우
        int result = Math.max(dp_right[1], dp_left[N - 2]);

        // 아무 원소도 삭제하지 않는 경우
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp_left[i]);
        }

        // 중간 원소를 삭제하는 경우
        for (int i = 1; i < N - 1; i++) {
            result = Math.max(result, dp_right[i + 1] + dp_left[i - 1]);
        }

        return result;
    }
}