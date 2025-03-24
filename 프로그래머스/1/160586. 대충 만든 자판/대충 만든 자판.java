import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> shortestPath = new HashMap<>();

        for (String key : keymap) {
            String[] split = key.split("");
            for (int i = 0; i < split.length; i++) {
                shortestPath.put(split[i], Math.min(i + 1, shortestPath.getOrDefault(split[i], i + 1)));
            }
        }
        int idx = 0;
        for (String target : targets) {
            answer[idx++] = getCount(target, shortestPath);
        }
        return answer;
    }

    public static int getCount(String target, Map<String, Integer> shortestPath) {
        int result = 0;
        for (String s : target.split("")) {
            if (shortestPath.containsKey(s)) {
                result += shortestPath.get(s);
            } else {
                return -1;
            }
        }
        return result;
    }
}