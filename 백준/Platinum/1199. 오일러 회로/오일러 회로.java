import java.io.*;
import java.util.*;

public class Main {
    static int[][] edges;
    static int n;

    static void dfs(int v, List<Integer> path) {
        for (int u = 0; u < n; u++) {
            while (edges[v][u] > 0) {
                edges[v][u]--;
                edges[u][v]--;
                dfs(u, path);
            }
        }
        path.add(v);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edges = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int count = Integer.parseInt(row[j]);
                if (count > 0 && i <= j) {
                    edges[i][j] += count;
                    if (i != j) {
                        edges[j][i] += count; // 대칭
                    }
                }
            }
        }

        // 오일러 회로 조건 확인: 모든 정점의 차수가 짝수여야 함
        int start = -1;
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += edges[i][j];
            }

            if (degree % 2 != 0) {
                System.out.println(-1);
                return;
            }

            if (start == -1 && degree > 0) {
                start = i;
            }
        }

        // 시작 정점이 없는 경우(모든 정점의 차수가 0인 경우)
        if (start == -1) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        dfs(start, path);

        // 모든 간선이 사용되었는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] > 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (int v : path) {
            sb.append(v + 1).append(' ');
        }
        System.out.println(sb.toString().trim());

        br.close();
    }
}