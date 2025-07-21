import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int M = people.length;
        Arrays.sort(people);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = M - 1; i >= 0; i--) {
            if (!pq.isEmpty() && pq.peek() >= people[i]) {
                pq.remove(); // 남은 자리
                continue;
            }

            // 새로운 보트
            pq.add(limit - people[i]);
            answer++;
        }

        return answer;
    }
}