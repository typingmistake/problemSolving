
import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // 빨리 끝나는 순으로 정렬
        int[][] sortedTargets = Arrays.stream(targets)
                .sorted((a, b) -> a[1] - b[1])
                .toArray(int[][]::new);

        int cur = -1;

        for (int[] target : sortedTargets) {
            if (cur <= target[0]) {
                answer++;
                cur = target[1];
            }
        }

        return answer;
    }
}