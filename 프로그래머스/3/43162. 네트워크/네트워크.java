import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, n, computers, visited);
            }
        }
        return answer;
    }

    public static void bfs(int s, int n, int[][] computers, boolean[] visited) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(s);
        visited[s] = true;
        while (!dq.isEmpty()) {
            int current = dq.removeFirst();
            for (int i = 0; i < n; i++) {
                // 연결되어있고, 방문하지 않은 컴퓨터 조회
                if (computers[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dq.add(i);
                }
            }
        }
    }
}