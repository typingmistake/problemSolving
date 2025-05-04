import java.util.Stack;

public class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                continue;
            }
            if (deliveries[i] > 0) {
                dStack.push(i);
            }
            if (pickups[i] > 0) {
                pStack.push(i);
            }
        }

        while (!dStack.isEmpty() || !pStack.isEmpty()) {
            int dLast = dStack.isEmpty() ? -1 : dStack.peek() + 1;
            int pLast = pStack.isEmpty() ? -1 : pStack.peek() + 1;

            int dCount = 0;
            int pCount = 0;

            // delivery Count가 cap을 초과할 때까지 배달
            while (dCount < cap && !dStack.isEmpty()) {
                int curr = dStack.pop();
                dCount += deliveries[curr];
                deliveries[curr] = 0;

                if (dCount > cap) {
                    dStack.push(curr);
                    deliveries[curr] = (dCount - cap);
                }
            }

            // pickup Count가 cap을 초과할 때까지 수거
            while (pCount < cap && !pStack.isEmpty()) {
                int curr = pStack.pop();
                pCount += pickups[curr];
                pickups[curr] = 0;

                if (pCount > cap) {
                    pStack.push(curr);
                    pickups[curr] = (pCount - cap);
                }
            }

            // 배송트럭 이동거리
            answer += Math.max(dLast, pLast) * 2L;
        }

        return answer;
    }
}