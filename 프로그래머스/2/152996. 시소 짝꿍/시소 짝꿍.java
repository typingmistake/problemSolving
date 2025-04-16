import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (int w : map.keySet()) {
            int count = map.get(w);

            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }
        }

        int[][] ratios = {
                { 2, 3 },
                { 2, 4 },
                { 3, 4 }
        };

        for (int[] ratio : ratios) {
            int a = ratio[0];
            int b = ratio[1];

            for (int w : map.keySet()) {
                // w*b = target*a => target = w*b/a
                if (w * b % a != 0)
                    continue;
                int target = w * b / a;
                if (map.containsKey(target) && w < target) {
                    answer += (long) map.get(w) * map.get(target);
                }
            }
        }

        return answer;
    }
}
