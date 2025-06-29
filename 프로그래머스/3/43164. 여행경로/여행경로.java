import java.util.*;

class Solution {
    class Graph {
        Map<String, Queue<String>> adjs;

        Graph() {
            adjs = new HashMap<>();
        }

        void add(String from, String to) {
            adjs.putIfAbsent(from, new PriorityQueue<>((a, b) -> a.compareTo(b)));
            adjs.get(from).add(to);
        }

        String getNext(String from) {
            Queue<String> nexts = adjs.get(from);
            return nexts.remove();
        }

        boolean hasNext(String from) {
            Queue<String> nexts = adjs.get(from);
            return nexts != null && !nexts.isEmpty();
        }
    }

    public String[] solution(String[][] tickets) {
        Graph graph = new Graph();
        for (String[] ticket : tickets) {
            graph.add(ticket[0], ticket[1]);
        }

        // 티켓 다 쓸 때까지 반복
        List<String> path = new ArrayList<>();
        dfs("ICN", graph, path);

        Collections.reverse(path);
        return path.toArray(String[]::new);
    }

    private void dfs(String airport, Graph graph, List<String> path) {
        while (graph.hasNext(airport)) {
            String next = graph.getNext(airport); // 다음 공항으로 이동, 티켓 제거
            dfs(next, graph, path);
        }

        // 막다른 공항에 도달했을 때 추가
        path.add(airport);
    }
}