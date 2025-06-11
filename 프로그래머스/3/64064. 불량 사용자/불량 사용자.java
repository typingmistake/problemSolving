import java.util.*;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = word;
        }

        List<String> search(String pattern) {
            List<String> result = new ArrayList<>();
            dfs(root, pattern, 0, result);
            return result;
        }

        private void dfs(TrieNode node, String pattern, int index, List<String> result) {
            if (index == pattern.length()) {
                if (node.word != null) {
                    result.add(node.word);
                }
                return;
            }

            char c = pattern.charAt(index);
            if (c == '*') {
                // 와일드카드: 모든 자식 노드 탐색
                for (TrieNode child : node.children.values()) {
                    dfs(child, pattern, index + 1, result);
                }
            } else {
                // 특정 문자: 해당 문자와 일치하는 자식 노드 탐색
                if (node.children.containsKey(c)) {
                    dfs(node.children.get(c), pattern, index + 1, result);
                }
            }
        }
    }

    Set<Set<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        Trie trie = new Trie();
        for (String id : user_id) {
            trie.insert(id);
        }

        List<List<String>> matchs = new ArrayList<>();
        for (String bannedId : banned_id) {
            List<String> matches = trie.search(bannedId);
            matchs.add(matches);
        }

        backtrack(matchs, 0, new HashSet<>());

        return resultSet.size();
    }

    private void backtrack(List<List<String>> matchs, int index, Set<String> used) {
        if (index == matchs.size()) {
            resultSet.add(new HashSet<>(used));
            return;
        }

        for (String candidate : matchs.get(index)) {
            if (!used.contains(candidate)) {
                used.add(candidate);
                backtrack(matchs, index + 1, used);
                used.remove(candidate);
            }
        }
    }
}