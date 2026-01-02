import java.io.*;
import java.util.*;


public class Main {
    public static class Graph {
        List<int[]> edges;

        public Graph() {
            this.edges = new ArrayList<>();
        }

        public void addEdge(int u, int v, int c) {
            edges.add(new int[]{u, v, c});
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Double[][] points = new Double[N][2]; // x, y 좌표
        List<double[]> graph = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            double x = Double.parseDouble(input[0]);
            double y = Double.parseDouble(input[1]);

            points[i] = new Double[]{x, y};
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                double dx = points[i][0] - points[j][0];
                double dy = points[i][1] - points[j][1];
                double dist = Math.sqrt(dx*dx + dy*dy);

                graph.add(new double[]{dist, i, j});
            }
        }

        graph.sort((a, b) -> Double.compare(a[0], b[0]));
        double answer = 0.0;

        int[] parents = new int[N];
        for(int i = 0; i < N; i++) parents[i] = i;

        for(double[] edge : graph){
            double cost = edge[0];
            int u = (int)edge[1];
            int v = (int)edge[2];

            int pu = find(parents, u);
            int pv = find(parents, v);

            if(pu != pv){
                parents[pu] = pv;
                answer += cost;
            }
        }

        System.out.printf("%.2f\n", answer);
    }

    public static int find(int[] parents, int u){
        if(parents[u] != u) parents[u] = find(parents, parents[u]);
        return parents[u];
    }
}