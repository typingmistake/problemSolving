import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Graph{
        Map<Integer, List<Integer>> graph;
        int[][] inDegree; // 건물 번호, 진입차수
        Graph(int N){
            graph = new HashMap<>();
            for(int i = 0; i < N; i++){
                graph.put(i, new ArrayList<>());
            }

            inDegree = new int[N][2];
            for(int i = 0; i < N; i++){
                inDegree[i][0] = i;
                inDegree[i][1] = 0;
            }
        }
        void addEdge(int u, int v){
            graph.get(u).add(v);
            inDegree[v][1]++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]), K = Integer.parseInt(line[1]);
            Graph graph = new Graph(N);
            int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 0 베이스

            while(K-- > 0){
                line = br.readLine().split(" ");
                int u = Integer.parseInt(line[0])-1;
                int v = Integer.parseInt(line[1])-1;
                graph.addEdge(u, v);
            }

            int last = Integer.parseInt(br.readLine());

            int[] dp = new int[N];
            Queue<Integer> q = new ArrayDeque<>();

            for(int[] node : graph.inDegree){
                int idx = node[0];
                dp[idx] = costs[idx];
                if(node[1] == 0) q.offer(idx);
            }

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next : graph.graph.get(curr)){
                    dp[next] = Math.max(dp[next], dp[curr] + costs[next]);
                    graph.inDegree[next][1]--;
                    if(graph.inDegree[next][1] > 0) continue;
                    q.offer(next);
                }
            }

            System.out.println(dp[last-1]);
        }
    }
}