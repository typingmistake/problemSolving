import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Graph{
        Map<Integer, Map<Integer, Integer>> adjList;
        int N;
        Graph(int N){
            this.N = N;
            adjList = new HashMap<>();
            for(int i = 0; i < N; i++){
                adjList.put(i, new HashMap<>());
            }
        }
        void addEdge(int u, int v, int w){
            adjList.get(u).put(v, Math.min(w, adjList.get(u).getOrDefault(v, Integer.MAX_VALUE)));
            adjList.get(v).put(u, Math.min(w, adjList.get(v).getOrDefault(u, Integer.MAX_VALUE)));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        Graph graph = new Graph(V);

        for(int i = 0; i < E; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0])-1;
            int v = Integer.parseInt(input[1])-1;
            int w = Integer.parseInt(input[2]);
            graph.addEdge(u, v, w);
        }

        input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        Set<Integer> burgers = new HashSet<>();
        String[] burgerArr = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            burgers.add(Integer.parseInt(burgerArr[i])-1);
        }

        input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);

        Set<Integer> coffees = new HashSet<>();
        String[] coffeeArr = br.readLine().split(" ");

        for(int i = 0; i < S; i++){
            coffees.add(Integer.parseInt(coffeeArr[i])-1);
        }

        int[] toBurger = dijkstra(graph, burgers, X);
        int[] toCoffee = dijkstra(graph, coffees, Y);

        int min = Integer.MAX_VALUE; // 최소 거리

        for(int i = 0; i < V; i++){
            if(burgers.contains(i) || coffees.contains(i)) continue; // 가게는 제외
            if(toBurger[i] == Integer.MAX_VALUE || toCoffee[i] == Integer.MAX_VALUE) continue; // 도달 불가능한 경우 제외
            min = Math.min(min, toBurger[i] + toCoffee[i]);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static int[] dijkstra(Graph graph, Set<Integer> shops, int X){
        int[] dist = new int[graph.N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[graph.N];

        PriorityQueue<int[]> pq = new PriorityQueue<>(graph.N, (a, b) -> Integer.compare(a[0], b[0]));

        for(int shop : shops){
            dist[shop] = 0;
            pq.add(new int[]{0, shop});
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int idx = curr[1];

            if(visited[idx]) continue;
            visited[idx] = true;

            for(Map.Entry<Integer, Integer> entry : graph.adjList.get(idx).entrySet()){
                int nextIdx = entry.getKey();
                int nextCost = cost + entry.getValue();

                if(!visited[nextIdx] && nextCost <= X && nextCost < dist[nextIdx]){
                    dist[nextIdx] = nextCost;
                    pq.add(new int[]{nextCost, nextIdx});
                }
            }
        }

        return dist;
    }
}