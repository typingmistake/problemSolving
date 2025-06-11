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

        List<List<String>> list = new ArrayList<>(); // 각 banned_id에 대해 가능한 user_id 목록
        for (String bannedId : banned_id) {
            List<String> matches = trie.search(bannedId);
            list.add(matches);
        }

        resultSet.clear();
        backtrack(list, 0, new HashSet<>());

        return resultSet.size();
    }

    private void backtrack(List<List<String>> list, int index, Set<String> used) {
        if (index == list.size()) {
            // resultSet.add(used); // 문제 : used 객체가 변경될 수 있으므로, 새로운 Set을 추가해야 함
            resultSet.add(new HashSet<>(used)); // 새로운 Set을 추가하여 변경 가능성 해결
            return;
        }

        for (String candidate : list.get(index)) {
            if (!used.contains(candidate)) {
                used.add(candidate);
                backtrack(list, index + 1, used);
                used.remove(candidate);
            }
        }
    }
}