import java.io.*;
import java.util.*;

public class Main {
    public static class Graph {
        int V;
        Map<Integer, List<Integer>> adjList;
        public Graph(int V) {
            this.V = V;
            this.adjList = new HashMap<>();
            for (int i = 0; i < V; i++) {
                adjList.put(i, new ArrayList<>());
            }
        }
        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            graph.addEdge(u, v);
        }

        System.out.println(solve(graph));
    }
    public static long solve(Graph graph) {
        int[] color = new int[graph.V];

        for (int i = 0; i < graph.V; i++) {
            if (color[i] != 0) continue;
            long[] cnt = draw(graph, color, i);
            if (cnt == null) return 0;
            return cnt[0]*cnt[1]*2L;
        }

        return 0;
    }

    public static long[] draw(Graph graph, int[] color, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = 1;
        long[] cnt = new long[2];

        while (!q.isEmpty()) {
            int curr = q.remove();
            cnt[color[curr]-1]++;
            int nextColor = color[curr] == 1 ? 2 : 1;

            for (int next : graph.adjList.get(curr)) {
                if (color[next] == nextColor) continue;
                if (color[next] == 0) {
                    q.add(next);
                    color[next] = nextColor;
                    continue;
                }
                return null;
            }
        }

        return cnt;
    }
}