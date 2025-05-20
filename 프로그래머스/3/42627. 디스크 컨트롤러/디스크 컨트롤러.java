import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Integer> result = new ArrayList<>();

        // 주어진 우선순위에 맞는 우선순위 큐
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Jobs를 요청시간이 빠른 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int idx = 0;
        int t = 0;

        // 모든 Jobs를 처리할 때까지
        while (idx < jobs.length) {
            // 현재까지 요청된 작업은 다 큐에 추가
            while (idx < jobs.length && jobs[idx][0] <= t) {
                pq.add(jobs[idx++]);
            }
            if (pq.isEmpty()) {
                t = jobs[idx][0];
                continue;
            }
            int[] curr = pq.remove();
            t += curr[1];
            result.add(t - curr[0]);
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            t += curr[1];
            result.add(t - curr[0]);
        }

        return result.stream().mapToInt(Integer::intValue).sum() / jobs.length;
    }
}