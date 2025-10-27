import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int[][] dp;
    static boolean[] visited;

    static void dfs(int node) {
        dp[node][0] = 0;
        dp[node][1] = 1;
        visited[node] = true;

        for (int next : adj[node]) {
            if(visited[next]) continue;

            dfs(next);

            dp[node][0] += dp[next][1];
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());

        adj = new ArrayList[N];
        visited = new boolean[N];
        dp = new int[N][2];

        for(int i=0; i<N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            String[] input = sc.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0);
        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }
}