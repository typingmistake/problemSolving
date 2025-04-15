import java.util.*;
import java.io.*;

public class Main {
    static class Graph {
        int nodeNum;
        ArrayList<int[]>[] edges;
        
        public Graph(int N) {
            this.nodeNum = N;
            this.edges = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                this.edges[i] = new ArrayList<>();
            }
        }
        
        public void add_edge(int u, int v, int w) {
            this.edges[u].add(new int[]{v, w});
        }
    }
    
    static int[] dijkstra(Graph g, int start, int N) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minheap.add(new int[]{0, start});
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        while (!minheap.isEmpty()) {
            int[] current = minheap.poll();
            int cost = current[0];
            int u = current[1];
            
            if (!visited.contains(u)) {
                dp[u] = cost;
                visited.add(u);
            }
            
            for (int[] next : g.edges[u]) {
                int v = next[0];
                int w = next[1];
                if (!visited.contains(v)) {
                    minheap.add(new int[]{cost + w, v});
                }
            }
        }
        
        return dp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        Graph g = new Graph(N);
        Graph reversed = new Graph(N);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.add_edge(u, v, w);
            reversed.add_edge(v, u, w);
        }
        
        int[] fromEnd = dijkstra(g, X, N);
        int[] fromStart = dijkstra(reversed, X, N);
        
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            if (fromEnd[i] != Integer.MAX_VALUE && fromStart[i] != Integer.MAX_VALUE) {
                ans = Math.max(ans, fromEnd[i] + fromStart[i]);
            }
        }
        
        System.out.println(ans);
        br.close();
    }
}