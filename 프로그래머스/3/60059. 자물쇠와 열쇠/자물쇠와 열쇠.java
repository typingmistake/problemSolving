class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // 네방향
        int m = key.length;
        int n = lock.length;
        int[][][] spinned = new int[4][m][m];
        for (int i = 0; i < 4; i++) {
            spinned[i] = spin(key, m);
            key = spinned[i];
        }

        // n + m - 1
        for (int i = -m; i < n + m; i++) {
            for (int j = -m; j < n + m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (check(spinned[k], lock, i, j, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // key 배열을 시계방향 90도 회전
    public static int[][] spin(int[][] key, int m) {
        int[][] temp = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][m - 1 - i] = key[i][j];
            }
        }

        return temp;
    }

    // key가 lock에 맞을 수 있는지 확인
    public static boolean check(int[][] key, int[][] lock, int x, int y, int m, int n) {
        int[][] temp = new int[n][n];

        // key를 lock에 맞춰서 넣기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (x + i < 0 || x + i >= n || y + j < 0 || y + j >= n) {
                    continue;
                }
                temp[x + i][y + j] += key[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] + lock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;

    }
}