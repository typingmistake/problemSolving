import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> visited = new HashSet<>();
        int[] p = new int[n];
        String prev = words[0];
        visited.add(prev);
        p[0]++;

        for (int i = 1; i < words.length; i++) {
            if (!prev.substring(prev.length() - 1)
                .equals(words[i].substring(0, 1))
                || visited.contains(words[i])) {
                return new int[] { i % n + 1, ++p[i % n]};
            }
            prev = words[i];
            visited.add(words[i]);
            p[i % n]++;
        }

        return new int[]{0,0};
    }
}