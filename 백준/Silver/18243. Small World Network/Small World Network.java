import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] graph = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0])-1;
            int v = Integer.parseInt(input[1])-1;

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        bellmanFord(graph); // 콜 바이 밸류
        int max = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                max = Math.max(max, graph[i][j]);
                if(max > MAX){
                    System.out.println("Big World!");
                    return;
                }
            }
        }

        System.out.println("Small World!");

    }

    public static void bellmanFord(int[][] graph){
        int N = graph.length;

        // 경유지
        for(int i = 0; i < N; i++){
            // 출발지
            for(int j = 0; j < N; j++){
                // 도착지
                for(int k = 0; k < N; k++){
                    if(graph[j][i] == Integer.MAX_VALUE || graph[i][k] == Integer.MAX_VALUE) continue;
                    if(graph[j][i]+graph[i][k] < graph[j][k]){
                        graph[j][k] = graph[j][i]+graph[i][k];
                    }
                }
            }
        }
    }
}