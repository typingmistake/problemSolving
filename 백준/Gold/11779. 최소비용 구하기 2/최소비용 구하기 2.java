import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Graph{
        Map<Integer, Map<Integer, Integer>> adjs;
        public Graph(int n){
            this.adjs = new HashMap<>();

            for(int i = 0; i < n; i++){
                this.adjs.put(i, new HashMap<>());
            }
        }

        public void addEdge(int u, int v, int weight){
            if(this.adjs.get(u).containsKey(v))
                weight = Math.min(weight, this.adjs.get(u).get(v));
            
            this.adjs.get(u).put(v, weight);
        }
    }

    public static void solve(Graph g, int start, int end) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> prevs = new HashMap<>(); // 이전 노드 기록

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, start, -1}); // cost, node, prev

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int node = curr[1];
            int cost = curr[0];
            int prev = curr[2];

            if(visited.contains(node)) continue;

            prevs.put(node, prev);
            visited.add(node);

            if(node == end){
                System.out.println(cost);
                break;
            }

            for(int next : g.adjs.get(node).keySet()){
                if(visited.contains(next)) continue;
                pq.add(new int[]{cost+g.adjs.get(node).get(next), next, node});
            }
        }

        // 경로 복원
        List<Integer> path = new ArrayList<>();
        int curr = end;

        while(curr != -1){
            path.add(curr + 1);
            curr = prevs.get(curr);
        }

        System.out.println(path.size());

        Collections.reverse(path);

        for(int i = 0; i < path.size(); i++){
            if(i > 0) System.out.print(" ");
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Graph g = new Graph(N);

        while(M-- > 0){
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0])-1;
            int v = Integer.parseInt(line[1])-1;
            int c = Integer.parseInt(line[2]);

            g.addEdge(u, v, c);
        }

        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0])-1;
        int end = Integer.parseInt(line[1])-1;

        solve(g, start, end);
    }
}