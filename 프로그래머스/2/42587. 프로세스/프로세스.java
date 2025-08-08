import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 내림차순 우선순위 큐
        Queue<Integer> queue = new LinkedList<>();

        for (int priority : priorities) {
            pq.offer(priority);
            queue.offer(priority);
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            int max = pq.peek(); // 현재 최대 우선순위 확인
            location--; // 현재 위치 감소

            if (curr < max) {
                queue.add(curr);
                location = (location < 0) ? queue.size() - 1 : location;
            } else {
                pq.poll(); // 최대 우선순위인 경우 제거
                answer++;
                if (location < 0) {
                    break;
                }
            }
        }

        return answer;
    }
}