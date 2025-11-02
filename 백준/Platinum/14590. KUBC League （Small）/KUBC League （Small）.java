import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    static int[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp = new int[N][1 << N];

        StringBuilder sb = new StringBuilder();
        sb.append(1);

        dp[0][1] = tsp(0, 1);
        System.out.println(dp[0][1] + 1);

        int curr = 0;
        int path = 1;
        for(int i = 0; i < dp[0][1]; i++) {
            for(int j = 0; j < N; j++) {
                if((curr == j) || ((path & (1 << j)) != 0)) continue;
                if(graph[curr][j] == 0) continue;

                int next = path | (1 << j);

                if(dp[j][next] == dp[curr][path]-1){
                    sb.append(" ").append(j + 1);
                    curr = j;
                    path = next;
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static int tsp(int curr, int visited) {
        if(dp[curr][visited] != 0) return dp[curr][visited]; // dp는 최대값 보장

        for(int i = 0; i < N; i++) {
            if((visited & (1 << i)) == 0 && graph[curr][i] != 0) { // i 노드가 방문되지 않았다면
                int next = visited | (1 << i);
                int cost = tsp(i, next);
                dp[curr][visited] = Math.max(dp[curr][visited], cost+1);
            }
        }

        return dp[curr][visited];
    }


}