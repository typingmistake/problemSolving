import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static List<Integer> resultPath = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            graph[u][v] = c;
        }

        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(1);
        solve(1 << 1, 1, 1, 0, initialPath);


        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(result);
            for(int i = 0; i < resultPath.size(); i++){
                if(i > 0) System.out.print(" ");
                System.out.print(resultPath.get(i));
            }
            System.out.println();
        }
    }

    static void solve(int visited, int start, int curr, int cost, List<Integer> path){
        if(Integer.bitCount(visited) == N){
            // 시작점으로 돌아갈 수 있는지 확인
            if(graph[curr][start] > 0){
                cost = Math.max(cost, graph[curr][start]);
                if(cost < result){
                    result = cost;
                    resultPath = new ArrayList<>(path);
                }
            }
            return;
        }

        for(int i = 1; i <= N; i++){
            if((visited & (1 << i)) != 0 || graph[curr][i] == 0) continue;

            int nextVisited = visited | (1 << i);
            int nextCost = Math.max(cost, graph[curr][i]);
            path.add(i);
            solve(nextVisited, start, i, nextCost, path);
            path.remove(path.size() - 1);
        }
    }
}