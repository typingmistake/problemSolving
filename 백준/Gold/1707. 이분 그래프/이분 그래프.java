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
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            Graph graph = new Graph(V);

            for (int i = 0; i < E; i++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]) - 1;
                int v = Integer.parseInt(input[1]) - 1;
                graph.addEdge(u, v);
            }

            System.out.println(solve(graph));
        }
    }
    public static String solve(Graph graph) {
        int[] color = new int[graph.V];

        for(int i = 0; i < graph.V; i++){
            if(color[i] != 0) continue;
            if(isValid(graph, color, i)) continue;
            return "NO";
        }

        return "YES";
    }

    public static boolean isValid(Graph graph, int[] color, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            int curr = q.remove();
            int nextColor = color[curr] == 1 ? 2 : 1;

            for(int next : graph.adjList.get(curr)){
                if(color[next] == nextColor) continue;
                if(color[next] == 0){
                    q.add(next);
                    color[next] = nextColor;
                    continue;
                }
                return false;
            }
        }

        return true;
    }
}