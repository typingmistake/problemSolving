import java.util.*;

class Solution {
    class Graph {
        int n; // 지역 개수
        Map<Integer, List<Integer>> graph; // 지역과 도로 정보

        public Graph(int n) {
            this.n = n;
            this.graph = new HashMap<>();
        }

        public void add(int u, int v) {
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        Graph g = new Graph(n);

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            g.add(u, v);
        }

        int[] cost = dijkstra(g, destination); // 목적지에서 각 노드까지의 최단거리
        for (int i = 0; i < sources.length; i++) {
            answer[i] = cost[sources[i]];
        }

        return answer;
    }

    public int[] dijkstra(Graph g, int destination) {
        Set<Integer> visited = new HashSet<>();
        int[] result = new int[g.n + 1];
        Arrays.fill(result, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { destination, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int node = cur[0]; // 현재 노드
            int cost = cur[1]; // 현재 비용

            if (visited.contains(node))
                continue;

            visited.add(node);
            result[node] = cost; // 그리디 방식으로 최단거리 구하기

            for (int next : g.graph.get(node)) {
                if (!visited.contains(next)) {
                    pq.add(new int[] { next, cost + 1 });
                }
            }
        }

        return result;
    }
}