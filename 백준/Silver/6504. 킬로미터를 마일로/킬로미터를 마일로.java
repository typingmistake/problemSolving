import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(sc.readLine());
            System.out.println(solve(num));
        }
    }

    static int solve(int num) {
        long MAX_T = 25_000;
        ArrayList<Long> list = new ArrayList<>(List.of(0L, 1L, 2L));
        long next = 3;

        while (next < MAX_T) {
            list.add(next);
            next = list.get(list.size() - 1) + list.get(list.size() - 2);
        }

        int ans = 0;
        int idx = list.size() - 1;
        while (num > 0) {
            if (list.get(idx) <= num) {
                num -= list.get(idx);
                ans += list.get(idx - 1);
            }
            idx--;
        }

        return ans;
    }
}
