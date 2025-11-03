import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static int[][] dp;
    static int[][] parent;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]) - 1; // 0 베이스로 변환
            int v = Integer.parseInt(line[1]) - 1;
            int c = Integer.parseInt(line[2]);
            graph[u][v] = c;
        }

        dp = new int[N][1 << N];
        parent = new int[N][1 << N];

        int result = tsp(0, 1);

        if(result == INF){
            System.out.println(-1);
            return;
        }

        System.out.println(result);

        int curr = 0;
        int visited = 1;

        for(int i = 0; i < N; i++){
            System.out.print((curr + 1));
            if(i != N - 1) System.out.print(" ");

            if(i < N - 1){
                int next = parent[curr][visited];
                visited |= (1 << next);
                curr = next;
            }
        }
    }

    static int tsp(int curr, int visited) {
        if(visited == (1 << N) - 1){
            return dp[curr][visited] = graph[curr][0];
        }

        if(dp[curr][visited] != 0) {
            return dp[curr][visited]; // 이미 계산된 상태
        }

        dp[curr][visited] = INF;

        for(int next = 1; next < N; next++){
            if((visited & (1 << next)) != 0 || graph[curr][next] >= INF) continue;
            int newVisited = visited | (1 << next);
            int cost = tsp(next, newVisited);

            if(cost == INF) continue;

            int max = Math.max(graph[curr][next], cost); // 현재 간선 또는 이후 경로 중 큰 값

            // dp, parent 갱신
            if(max < dp[curr][visited]) {
                dp[curr][visited] = max;
                parent[curr][visited] = next;
            }
        }

        return dp[curr][visited];
    }
}