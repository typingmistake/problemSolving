import java.util.*;

class Solution {
    class Graph {
        int num;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        Graph(int n) {
            this.num = n;
            for (int i = 1; i <= n; i++) {
                adj.put(i, new ArrayList<>());
            }
        }

        void add(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public int solution(int n, int[][] edge) {
        Graph g = new Graph(n);

        for (int[] e : edge) {
            g.add(e[0], e[1]);
        }

        int[] cost = dijstra(1, g);
        int M = Arrays.stream(cost).max().getAsInt();

        return (int) Arrays.stream(cost).filter(x -> x == M).count();
    }

    public static int[] dijstra(int start, Graph graph) {
        int[] cost = new int[graph.num + 1];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();

            if (visited.contains(curr[0]))
                continue;

            visited.add(curr[0]);
            cost[curr[0]] = curr[1];

            for (int next : graph.adj.get(curr[0])) {
                if (!visited.contains(next))
                    pq.add(new int[] { next, curr[1] + 1 });
            }

        }

        return cost;
    }
}