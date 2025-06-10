
class Solution {

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] fare : fares) {
            int u = fare[0] - 1;
            int v = fare[1] - 1;
            int cost = fare[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }

        floydWarshall(dist, n);

        for (int i = 0; i < n; i++) {
            if (dist[s - 1][i] == Integer.MAX_VALUE ||
                    dist[i][a - 1] == Integer.MAX_VALUE ||
                    dist[i][b - 1] == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.min(answer, dist[s - 1][i] + dist[i][a - 1] + dist[i][b - 1]);
        }

        return answer;
    }

    public static void floydWarshall(int[][] dist, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE &&
                            dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}