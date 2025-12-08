import java.io.*;
import java.util.*;

public class Main {
    static Graph graph;
    static boolean[] visited;
    static long cnt = 0;
    static long res = 0;

    public static class Graph {
        Map<Integer, Map<Integer, Integer>> adjList;
        Map<Integer, List<Integer>> edges;
        public Graph(int N){
            adjList = new HashMap<>();
            edges = new HashMap<>();

            for(int i = 0; i < N; i++){
                adjList.put(i, new HashMap<>());
                edges.put(i, new ArrayList<>());
            }
        }
        public void addEdge(int u, int v, int w){
            adjList.get(u).put(v, w);
            adjList.get(v).put(u, w);
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        public void sortEdges(int N){
            for(int i = 0; i < N; i++){
                edges.get(i).sort((a, b) -> b - a);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        graph = new Graph(N);

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            graph.addEdge(u, v, 1);
        }

        graph.sortEdges(N);

        visited = new boolean[N];
        dfs(R - 1, 0);

        System.out.println(res);
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        cnt++;
        res += cnt * depth;

        for (int next : graph.edges.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}