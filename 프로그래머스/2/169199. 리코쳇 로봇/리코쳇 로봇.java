import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] curr = new int[2]; // 0: x, 1: y
        outerLoop: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    curr[0] = j;
                    curr[1] = i;
                    break outerLoop;
                }
            }

        }
        System.out.println("x: " + curr[0] + ", y: " + curr[1]);
        int answer = bfs(curr, board);
        return answer;
    }

    public static int bfs(int[] current, String[] board) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { current[0], current[1], 0 }); // x, y, cost
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[current[1]][current[0]] = true;

        while (!dq.isEmpty()) {
            int[] curr = dq.removeFirst();
            if (board[curr[1]].charAt(curr[0]) == 'G') {
                return curr[2];
            }
            int[][] next = findNext(curr, board);
            for (int i = 0; i < next.length; i++) {
                int[] n = next[i];
                if (!visited[n[1]][n[0]]) {
                    visited[n[1]][n[0]] = true;
                    dq.add(new int[] { n[0], n[1], n[2] });
                }
            }
        }

        return -1;
    }

    public static int[][] findNext(int[] current, String[] board) {
        int[][] res = new int[4][3];
        int cost = current[2];
        int N = board.length;
        int M = board[0].length();
        int[][] direction = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < 4; i++) {
            int[] curr = { current[0], current[1] };
            int[] dir = direction[i];
            while (true) {
                curr[0] += dir[0];
                curr[1] += dir[1];
                if (curr[0] < 0 || curr[0] >= M ||
                        curr[1] < 0 || curr[1] >= N ||
                        board[curr[1]].charAt(curr[0]) == 'D') {
                    curr[0] -= dir[0];
                    curr[1] -= dir[1];
                    break;
                }
            }
            res[i] = new int[] { curr[0], curr[1], cost + 1 };
        }
        return res;
    }

}