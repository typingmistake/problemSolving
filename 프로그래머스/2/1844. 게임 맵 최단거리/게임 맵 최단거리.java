import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int r = maps.length;
        int c = maps[0].length;
        int[] start = new int[] { 0, 0 };

        return bfs(maps, r, c, start);
    }

    public static int bfs(int[][] maps, int r, int c, int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        q.add(new int[] { start[0], start[1], 1 }); // x, y, cnt
        visited[start[1]][start[0]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];

            if (x == c - 1 && y == r - 1) {
                return cnt;
            }

            int[][] nexts = { { curr[0], curr[1] + 1 }, { curr[0] + 1, curr[1] }, { curr[0], curr[1] - 1 },
                    { curr[0] - 1, curr[1] } };

            for (int[] next : nexts) {
                // 범위 확인
                if (next[0] < 0 || next[0] >= c || next[1] < 0 || next[1] >= r) {
                    continue;
                }

                // 방문 여부 및 벽 확인
                if (maps[next[1]][next[0]] == 0 || visited[next[1]][next[0]]) {
                    continue;
                }
                
                // 방문
                q.add(new int[] { next[0], next[1], cnt + 1 });
                visited[next[1]][next[0]] = true;
            }
        }

        return -1; // 도달 불가
    }

}