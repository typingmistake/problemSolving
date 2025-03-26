import java.util.*;

class Solution {
    static int MONTH_DAY = 28;
    static int YEAR_MONTH = 12;

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> expire = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int todayDays = calcDays(today);

        for (String term : terms) {
            String[] split = term.split(" ");
            expire.put(split[0], Integer.parseInt(split[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            if (calcDays(split[0]) + MONTH_DAY * expire.get(split[1]) <= todayDays) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int calcDays(String day) {
        String[] split = day.split("\\.");
        int y = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);

        return (y - 2000) * YEAR_MONTH * MONTH_DAY + (m - 1) * MONTH_DAY + d;
    }
}