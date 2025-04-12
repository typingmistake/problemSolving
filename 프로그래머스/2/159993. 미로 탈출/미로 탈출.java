import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2]; // 시작지점 x,y
        int[] lever = new int[2]; // 레버지점 x,y
        int[] end = new int[2]; // 도착지점 x,y

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[1] = i;
                    start[0] = j;
                }
                if (maps[i].charAt(j) == 'L') {
                    lever[1] = i;
                    lever[0] = j;
                }
                if (maps[i].charAt(j) == 'E') {
                    end[1] = i;
                    end[0] = j;
                }
            }
        }
        int res = bfs(maps, start, lever);
        if (res == -1)
            return -1;
        answer += res;

        res = bfs(maps, lever, end);
        if (res == -1)
            return -1;
        answer += res;

        return answer;
    }

    public static int bfs(String[] maps, int[] start, int[] end) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { start[0], start[1], 0 });
        visited[start[1]][start[0]] = true;

        while (!dq.isEmpty()) {
            int[] curr = dq.removeFirst();

            if (curr[0] == end[0] && curr[1] == end[1]) {
                return curr[2];
            }

            int[][] nexts = new int[][] {
                    { curr[0] + 1, curr[1] },
                    { curr[0] - 1, curr[1] },
                    { curr[0], curr[1] + 1 },
                    { curr[0], curr[1] - 1 } };

            for (int[] next : nexts) {
                int x = next[0];
                int y = next[1];
                if ((0 <= x && x < m) && (0 <= y && y < n) && !visited[y][x] && maps[y].charAt(x) != 'X') {
                    visited[y][x] = true;
                    dq.add(new int[] { x, y, curr[2] + 1 });
                }
            }
        }

        return -1;
    }
}