import java.util.*;

class Solution {
    static String CNT = "cnt";

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> target = new HashMap<>();
        Map<String, Integer> curr = new HashMap<>();
        curr.put(CNT, 0);

        for (int i = 0; i < want.length; i++) {
            target.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {
            if (i >= 10) {
                sub(target, curr, discount[i - 10]);
            }
            
            add(target, curr, discount[i]);

            if (curr.get(CNT) >= 10)
                answer++;
        }

        return answer;
    }

    public static void sub(Map<String, Integer> target, Map<String, Integer> curr, String item) {
        if (target.containsKey(item) && curr.getOrDefault(item, 0) > 0) {
            curr.put(item, curr.get(item) - 1);
            if(curr.get(item) < target.get(item)){
                curr.put(CNT, curr.get(CNT) - 1);
            }
        }
    }

    public static void add(Map<String, Integer> target, Map<String, Integer> curr, String item) {
        if (target.containsKey(item)) {
            if(curr.getOrDefault(item, 0) < target.get(item))
                curr.put(CNT, curr.get(CNT) + 1);
            curr.put(item, curr.getOrDefault(item, 0) + 1);
        }
    }
}