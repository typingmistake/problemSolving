import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> nexts = new HashMap<>(Map.of(
                0, List.of(7),
                1, List.of(2, 4),
                2, List.of(1, 3, 5),
                3, List.of(2, 6),
                4, List.of(1, 5, 7),
                5, List.of(2, 4, 6, 8),
                6, List.of(3, 5, 9),
                7, List.of(0, 4, 8),
                8, List.of(5, 7, 9),
                9, List.of(6, 8)
        ));

        while(T-- > 0){
            int[] dp = new int[10];
            Arrays.fill(dp, 1);

            int N = Integer.parseInt(br.readLine());

            for(int i = 1; i < N; i++){
                int[] newDp = new int[10];
                
                for(int j = 0; j < 10; j++){
                    for(int next : nexts.get(j)){
                        newDp[next] += dp[j];
                    }
                    newDp[j] %= 1_234_567;
                }
                dp = newDp;
            }

            System.out.println(Arrays.stream(dp).sum() % 1_234_567);
        }
    }
}