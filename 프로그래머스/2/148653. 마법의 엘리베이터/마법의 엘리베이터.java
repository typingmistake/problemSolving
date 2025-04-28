import java.util.*;

public class Solution {

    public static final int MAX = 100_000_000;

    public int solution(int storey) {
        return bfs(storey);
    }

    static int bfs(int storey) {
        Set<Integer> visited = new HashSet<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{storey, 0});
        visited.add(storey);

        while (!dq.isEmpty()) {
            int[] curr = dq.removeFirst();
            if (curr[0] == 0) return curr[1];
            
            int temp = 1;
            while (temp <= curr[0] || temp <= MAX - curr[0]) {
                // 더하기 연산
                if (curr[0] + temp <= MAX && !visited.contains(curr[0] + temp)) {
                    dq.add(new int[]{curr[0] + temp, curr[1] + 1});
                    visited.add(curr[0] + temp);
                }
                
                // 빼기 연산
                if (curr[0] - temp >= 0 && !visited.contains(curr[0] - temp)) {
                    dq.add(new int[]{curr[0] - temp, curr[1] + 1});
                    visited.add(curr[0] - temp);
                }
                
                temp *= 10;
            }
        }
        return -1;
    }
}