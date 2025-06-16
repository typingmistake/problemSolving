import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Map<String, List<String>> adjs = new HashMap<>();

        // 깊은 복사 + begin 단어 추가
        String[] wordsWithBegin = new String[words.length + 1];
        System.arraycopy(words, 0, wordsWithBegin, 0, words.length);
        wordsWithBegin[words.length] = begin;

        for (String word : wordsWithBegin) {
            List<String> adj = new ArrayList<>();
            for (String other : words) {
                if (other.equals(word))
                    continue;
                if (isAdj(word, other)) {
                    adj.add(other);
                }
            }
            adjs.put(word, adj);
        }

        return bfs(begin, target, adjs);
    }

    public static boolean isAdj(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1)
                return false;
        }
        return diff == 1;
    }

    public int bfs(String begin, String target, Map<String, List<String>> adj) {
        Deque<Object[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>(); // 방문한 단어를 추적
        q.add(new Object[] { begin, 0 });
        visited.add(begin);
        while (!q.isEmpty()) {
            Object[] curr = q.removeFirst();
            String currWord = (String) curr[0];
            int currCnt = (int) curr[1];

            if (currWord.equals(target)) {
                return currCnt;
            }

            for (String next : adj.get(currWord)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(new Object[] { next, currCnt + 1 });
                }
            }

        }

        return 0; // 목표 단어에 도달할 수 없음.
    }
}