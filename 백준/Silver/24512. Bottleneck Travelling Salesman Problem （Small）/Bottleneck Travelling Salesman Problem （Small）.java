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

        for(int start = 1; start <= N; start++){
            List<Integer> initialPath = new ArrayList<>();
            initialPath.add(start);
            solve(1 << start, start, start, 0, initialPath);
        }

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

    static void solve(int visited, int start, int curr, int maxCost, List<Integer> path){
        if(Integer.bitCount(visited) == N){
            if(graph[curr][start] > 0){
                int finalMaxCost = Math.max(maxCost, graph[curr][start]);
                if(finalMaxCost < result){
                    result = finalMaxCost;
                    resultPath = new ArrayList<>(path);
                }
            }
            return;
        }

        for(int i = 1; i <= N; i++){
            if((visited & (1 << i)) != 0 || graph[curr][i] == 0) continue;

            int nextVisited = visited | (1 << i);
            int nextMaxCost = Math.max(maxCost, graph[curr][i]);
            path.add(i);
            solve(nextVisited, start, i, nextMaxCost, path);
            path.remove(path.size() - 1);
        }
    }
}