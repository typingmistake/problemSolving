import java.util.*;

class Solution {
    static boolean visited[][];
    static int[][] union;
    static HashMap<Integer, Integer> sizeMap;
    static int idx;

    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        visited = new boolean[n][m];
        union = new int[n][m];
        sizeMap = new HashMap<>();
        idx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] != 0) {
                    int size = bfs(land, i, j, idx);
                    sizeMap.put(idx, size);
                    idx++;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (union[i][j] > 0) {
                    set.add(union[i][j]);
                }
            }

            int total = 0;
            for (int id : set) {
                total += sizeMap.get(id);
            }

            answer = Math.max(answer, total);
        }

        return answer;
    }

    private int bfs(int[][] land, int x, int y, int areaId) {
        int n = land.length;
        int m = land[0].length;
        int size = 0;
        int value = land[x][y];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] { x, y });
        visited[x][y] = true;

        int[][] next = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curX = cur[0];
            int curY = cur[1];

            union[curX][curY] = areaId;
            size++;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + next[i][0];
                int nextY = curY + next[i][1];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (!visited[nextX][nextY] && land[nextX][nextY] == value) {
                    visited[nextX][nextY] = true;
                    dq.add(new int[] { nextX, nextY });
                }
            }
        }

        return size;
    }
}