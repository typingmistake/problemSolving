import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return b[0] - a[0];
            }
            return a[col - 1] - b[col - 1];
        });

        int[] sum = new int[data.length];
        Arrays.fill(sum, 0);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum[i] += data[i][j] % (i + 1);
            }
        }

        for (int i = row_begin - 1; i < row_end; i++) {
            answer = answer ^ sum[i];
        }

        return answer;
    }
}