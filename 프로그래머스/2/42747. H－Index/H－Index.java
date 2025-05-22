import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 논문 인용수 내림차순 정렬
        Integer[] sorted = Arrays.stream(citations)
                .boxed()
                .sorted((a, b) -> b - a)
                .toArray(Integer[]::new);

        int idx = 0;
        int ans = 0;
        while (idx < sorted.length) {
            // idx+1은 sorted[idx] 이상 값의 개수
            if (sorted[idx] >= idx+1) {
                ans = Math.max(idx+1, ans);
            }
            idx++;
        }

        return ans;
    }
}