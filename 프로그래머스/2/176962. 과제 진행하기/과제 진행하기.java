
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        int currIdx = 0;
        int ansIdx = 0;
        String[][] sortedPlans = sort(plans);
        Deque<String[]> st = new ArrayDeque<>();
        int currTime = 0;

        while (true) {
            // 모든 작업 마무리
            if (currIdx == n && st.isEmpty()) {
                break;
            }
            // 모든 작업이 스택에 쌓인 경우
            if (currIdx == n) {
                while (!st.isEmpty()) {
                    String name = st.pollLast()[0];
                    answer[ansIdx++] = name;
                }
            } else {
                String[] currPlan = sortedPlans[currIdx];
                int currStartTime = getTime(currPlan[1]);
                int nextStartTime = currIdx + 1 < n ? getTime(sortedPlans[currIdx + 1][1]) : Integer.MAX_VALUE;
                int currDuration = Integer.parseInt(currPlan[2]);

                // 시간 여유가 생기면 스택에 있는 작업을 처리
                while (!st.isEmpty() && currTime < currStartTime) {
                    String[] topPlan = st.pollLast();
                    int topPlanDuration = Integer.parseInt(topPlan[2]);
                    if (currTime + topPlanDuration <= currStartTime) {
                        currTime += topPlanDuration;
                        answer[ansIdx++] = topPlan[0];
                    } else {
                        topPlan[2] = String.valueOf(topPlanDuration - (currStartTime - currTime));
                        st.addLast(topPlan);
                        currTime = currStartTime;
                        break;
                    }
                }

                if (currStartTime + currDuration <= nextStartTime) {
                    currTime = currStartTime + currDuration;
                    answer[ansIdx++] = currPlan[0];
                } else {
                    currPlan[2] = String.valueOf(currDuration - (nextStartTime - currStartTime));
                    st.addLast(currPlan);
                    currTime = nextStartTime;
                }
                currIdx++;
            }
        }
        return answer;

    }

    public static String[][] sort(String[][] plans) {
        return Arrays.stream(plans)
                .sorted((a, b) -> {
                    int A = getTime(a[1]);
                    int B = getTime(b[1]);
                    return A - B;
                })
                .toArray(String[][]::new);
    }

    public static int getTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}