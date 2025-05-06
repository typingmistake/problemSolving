
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] scores) {

        // 완호의 점수 합
        int[] target = scores[0];
        
        // 
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> filtered = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            int[] score = scores[i];
            if (score[1] >= max) {
                filtered.add(score);
                max = score[1];
                continue;
            }

            if (scores[i][0] == target[0] && scores[i][1] == target[1]) {
                return -1;
            }
        }

        // 합 내림차순으로 정렬
        filtered.sort((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        int tragetSum = target[0] + target[1];

        for (int i = 0; i < filtered.size(); i++) {
            int[] score = filtered.get(i);
            if (score[0] + score[1] == tragetSum) {
                return i+1;
            }
        }

        return -1;
    }
}