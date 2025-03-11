import java.lang.Math;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = (int) Math.ceil((double) n / w);
        int[][] dp = new int[h][w];
        int row = 0, col = 0;
        int x = 0, y = 0;

        for (int i = 1; i < n + 1; i++) {
            dp[row][col] = i;
            if (i == num) {
                y = row;
                x = col;
            }

            if (i % w == 0) {
                row++;
            } else {
                if (row % 2 == 0) {
                    col++;
                } else {
                    col--;
                }
            }
        }

        answer = 0;

        while (y <= h - 1 && dp[y][x] != 0) {
            answer++;
            y++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 3, 6));
    }
}