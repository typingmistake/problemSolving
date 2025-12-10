import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solve(0, N, 0, new ArrayList<>()));
    }
    public static int solve(int depth, int n, int used, List<Integer> list) {
        if (depth == n) {
            return count(list);
        }

        int max = -1;

        for(int i = 0; i < n; i++) {
            if ((used & (1 << i)) != 0) continue;
            list.add(arr[i]);
            max = Math.max(max, solve(depth + 1, n, used | (1 << i), list));
            list.remove(list.size() - 1);
        }

        return max;
    }
    public static int count(List<Integer> list) {
        int cnt = 0;
        Set<Integer> prefixSums = new HashSet<>();

        int sum = 0;
        for (int val : list) {
            sum += val;

            if (prefixSums.contains(sum - 50)) {
                cnt++;
            }
            prefixSums.add(sum);
        }

        return cnt;
    }
}