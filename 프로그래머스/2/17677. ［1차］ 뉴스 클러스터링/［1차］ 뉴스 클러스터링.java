import java.util.*;

class Solution {
    static int mul = 65_536;
    static String pattern = "[a-zA-Z]*";

    public int solution(String str1, String str2) {
        Map<String, Integer> mapA = accum(str1);
        Map<String, Integer> mapB = accum(str2);

        if (mapA.isEmpty() && mapB.isEmpty())
            return mul;

        Map<String, Integer> union = new HashMap<>(mapA);
        for (String key : mapB.keySet()) {
            union.put(key, Math.max(union.getOrDefault(key, 0), mapB.get(key)));
        }

        Map<String, Integer> inter = new HashMap<>();
        for (String key : mapA.keySet()) {
            if (mapB.containsKey(key)) {
                inter.put(key, Math.min(mapA.get(key), mapB.get(key)));
            }
        }

        int unionSize = union.values().stream().mapToInt(n -> n).sum();
        int interSize = inter.values().stream().mapToInt(n -> n).sum();

        return (int) (interSize * mul / unionSize);
    }

    static Map<String, Integer> accum(String str) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if (sub.matches(pattern)) {
                String key = sub.toLowerCase();
                result.put(key, result.getOrDefault(key, 0) + 1);
            }
        }
        return result;
    }
}
