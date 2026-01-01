import java.io.*;
import java.util.*;


public class Main {
    public static class Graph {
        List<int[]> edges;
        int size;

        public Graph(int N) {
            this.size = N;
            this.edges = new ArrayList<>();
        }

        public void addEdge(int u, int v, int c) {
            edges.add(new int[]{u, v, c});
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Graph graph = new Graph(N);

        for(int i = 0; i <= M; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph.addEdge(u, v, c == 0 ? 1 : 0);
        }

        long best = best(graph);
        long worst = worst(graph);
        System.out.println(worst-best);
    }
    public static long worst(Graph graph){
        int N = graph.size;
        int cost = 0;
        int[] parents = new int[N+1];
        graph.edges.sort((a, b) -> b[2] - a[2]); // 비용 내림차순
        for(int i = 1; i <= N; i++) parents[i] = i;

        for(int i = 1; i <= N; i++) parents[i] = i;

        for(int[] edge : graph.edges){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            int pu = find(parents, u);
            int pv = find(parents, v);

            if(pu != pv){
                parents[pu] = pv;
                cost += c;
            }
        }

        return (long)cost*cost;
    }

    public static long best(Graph graph){
        int N = graph.size;
        int cost = 0;
        int[] parents = new int[N+1];
        graph.edges.sort((a, b) -> a[2] - b[2]); // 비용 오름차순

        for(int i = 1; i <= N; i++) parents[i] = i;

        for(int[] edge : graph.edges){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            int pu = find(parents, u);
            int pv = find(parents, v);

            if(pu != pv){
                parents[pu] = pv;
                cost += c;
            }
        }

        return (long)cost*cost;
    }

    public static int find(int[] parents, int u){
        if(parents[u] != u) parents[u] = find(parents, parents[u]);
        return parents[u];
    }
}