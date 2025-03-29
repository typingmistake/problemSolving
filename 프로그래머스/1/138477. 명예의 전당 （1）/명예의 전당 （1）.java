import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> awards = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < score.length; i++) {
            awards.add(score[i]);

            Collections.sort(awards, (a, b) -> {
                return b - a;
            });

            if (i >= k) {
                awards.remove(awards.size() - 1);
            }

            answer[idx++] = awards.get(awards.size() - 1);
        }
        return answer;
    }
}