import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        return bfs(board, N);
    }

    public static int bfs(int[][] board, int N) {
        // y, x, cost, 진행방향(1: 상, 2: 하, 3: 좌, 4: 우)
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] costs = new int[N][N][5];

        for (int[][] row : costs) {
            for (int[] a : row) {
                Arrays.fill(a, Integer.MAX_VALUE);
            }
        }

        if (board[0][1] == 0) {
            q.add(new int[] { 0, 1, 100, 4 });
            costs[0][1][4] = 100;
        }

        if (board[1][0] == 0) {
            q.add(new int[] { 1, 0, 100, 2 });
            costs[1][0][2] = 100;
        }

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int y = curr[0], x = curr[1], cost = curr[2], dir = curr[3];

            // 가지치기
            if (costs[y][x][dir] < cost) {
                continue;
            }

            int[][] nexts = { { y - 1, x, cost, 1 }, { y + 1, x, cost, 2 }, { y, x - 1, cost, 3 },
                    { y, x + 1, cost, 4 } };
            for (int[] next : nexts) {
                if (next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= N || board[next[0]][next[1]] == 1) {
                    continue; // 범위 밖이거나 벽인 경우 건너뛰기
                }

                if (dir == next[3]) {
                    next[2] += 100; // 직진
                } else {
                    next[2] += 600; // 회전
                }

                q.add(next);

                costs[next[0]][next[1]][next[3]] = Math.min(costs[next[0]][next[1]][next[3]], next[2]);
            }
        }

        return Arrays.stream(costs[N - 1][N - 1])
                .min().orElse(0);
    }
}