import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String numStr = sc.readLine();
        int N = Integer.parseInt(numStr);
        Map<Integer, Integer> cntMap = new HashMap<>();

        while(N > 0) {
            cntMap.put(N % 10, cntMap.getOrDefault(N % 10, 0) + 1);
            N /= 10;
        }

        int result = solve("", numStr, cntMap);
        System.out.println(result != Integer.MAX_VALUE ? result : 0);
    }

    static int solve(String cur, String target, Map<Integer, Integer> cntMap) {
        if(cur.length() == target.length() && Integer.parseInt(cur) > Integer.parseInt(target)) {
            return Integer.parseInt(cur);
        }

        int result = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > 0) {
                cntMap.put(key, value - 1);
                String next = cur + key;
                result = Math.min(result, solve(next, target, cntMap));
                cntMap.put(key, value); // 복원
            }
        }

        return result;
    }
}
