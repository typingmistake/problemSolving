class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        for (String req : requests) {
            if (req.length() == 1) {
                runA(req.charAt(0), map, n, m);
            } else {
                runB(req.charAt(0), map, n, m);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '\0') {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void runA(char target, char[][] map, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            clear(target, map, i, 0, visited);
            clear(target, map, i, n - 1, visited);
        }

        for (int i = 1; i < n - 1; i++) {
            clear(target, map, 0, i, visited);
            clear(target, map, m - 1, i, visited);
        }
    }

    //
    public static void runB(char target, char[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '\0';
                }
            }
        }
    }

    public static void clear(char target, char[][] map, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= map[0].length || y < 0 || y >= map.length || visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        if (map[y][x] == target) {
            map[y][x] = '\0';
            return;
        }

        if (map[y][x] != '\0') {
            return;
        }

        clear(target, map, x - 1, y, visited);
        clear(target, map, x + 1, y, visited);
        clear(target, map, x, y - 1, visited);
        clear(target, map, x, y + 1, visited);
    }

}