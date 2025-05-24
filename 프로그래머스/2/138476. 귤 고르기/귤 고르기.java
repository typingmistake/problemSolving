import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> count = new HashMap<>();

        // 사이즈 카운트 추가
        for (int num : tangerine) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        // 내림차순 정렬
        List<Integer> sorted = new ArrayList<>();
        for (int n : count.keySet()) {
            sorted.add(count.get(n));
        }
        Collections.sort(sorted, (a, b) -> b - a);

        for (int i = 0; i < sorted.size(); i++) {
            k -= sorted.get(i);
            if (k <= 0) {
                return i + 1;
            }
        }

        return -1;
    }
}