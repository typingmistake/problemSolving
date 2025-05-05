class Solution {
    static int m;
    static int n;

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int k = balls.length;
        this.m = m;
        this.n = n;
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = solve(startX, startY, balls[i][0], balls[i][1]);
        }
        return answer;
    }

    public int solve(int x, int y, int targetX, int targetY) {
        int res = Integer.MAX_VALUE;
        // 왼쪽 벽
        if (targetY != y || targetX > x) {
            int dis = getDistance(x, y, -targetX, targetY);
            res = Math.min(res, dis);
        }
        // 오른쪽 벽
        if (targetY != y || targetX < x) {
            int dis = getDistance(x, y, 2 * m - targetX, targetY);
            res = Math.min(res, dis);
        }
        // 아래쪽 벽
        if (targetX != x || targetY > y) {
            int dis = getDistance(x, y, targetX, -targetY);
            res = Math.min(res, dis);
        }
        // 위쪽 벽
        if (targetX != x || targetY < y) {
            int dis = getDistance(x, y, targetX, 2 * n - targetY);
            res = Math.min(res, dis);
        }
        // y = x
        if (targetX - x == targetY - y) {
            int dis;
            if (targetX > x) {
                dis = getDistance(x, y, -targetX, -targetY);
            } else {
                dis = getDistance(x, y, 2 * m - targetX, 2 * n - targetY);
            }
            res = Math.min(res, dis);
        }
        // y = -x
        if (x - targetX == targetY - y) {
            int dis;
            if (targetX > x) {
                dis = getDistance(x, y, -targetX, 2 * n - targetY);
            } else {
                dis = getDistance(x, y, 2 * m - targetX, -targetY);
            }
            res = Math.min(res, dis);
        }

        return res;
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}