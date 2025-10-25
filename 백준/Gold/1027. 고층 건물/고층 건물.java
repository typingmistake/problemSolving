import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[] nums = Arrays.stream(sc.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        double[][] slopes = new double[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                slopes[i][j] = (double) (nums[j] - nums[i]) / (j - i); // 기울기 계산
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                boolean visible = true;
                double slope = slopes[i][j];
                int s = Math.min(i, j);
                int e = Math.max(i, j);

                for (int k = s + 1; k < e; k++) {
                    double h = nums[s] + slope * (k - s); // 직선 상의 높이
                    if (h <= nums[k]) {
                        visible = false;
                        break;
                    }
                }

                if (visible) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
