import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static int[][] cntMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        cntMap = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int res = 0;

        Set<String> melt = updateCnt();

        while (!melt.isEmpty()) {
            res++;

            for (String pos : melt) {
                String[] parts = pos.split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                map[x][y] = 0;
            }

            melt = updateCnt();
        }

        System.out.println(res);
    }

    static Set<String> updateCnt() {
        Set<String> next = new HashSet<>();
        boolean[][] air = bfs();
        cntMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (air[nx][ny]) cntMap[i][j]++;
                }

                if (cntMap[i][j] >= 2) next.add(i + " " + j);
            }
        }

        return next;
    }

    static boolean[][] bfs(){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return visited;
    }
}