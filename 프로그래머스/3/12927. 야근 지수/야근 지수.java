
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int work : works) {
            pq.add(work);
        }
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty())
                break;
            int curr = pq.remove();
            if (curr > 0) {
                pq.add(curr - 1);
            }
        }
        for (int work : pq) {
            answer += work * work;
        }
        return answer;
    }
}