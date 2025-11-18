import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            String num = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(num.charAt(j)+"");
            }
        }


        System.out.println(bfs(map, N, M, K));
    }

    public static int bfs (int[][] map, int N, int M, int K){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[N][M];

        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], -1);
        }
        
        q.add(new int[]{0,0,1,K});

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];
            int k = curr[3];

            if(x == N-1 && y == M-1) return d;

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 바로 이동
                if(map[nx][ny] == 0){
                    if(visited[nx][ny] >= k) continue;
                    q.add(new int[]{nx, ny, d+1, k});
                    visited[nx][ny] = k;
                    continue;
                }

                // 벽 부수고 이동
                if(k > 0){
                    if(visited[nx][ny] >= k-1)  continue;
                    q.add(new int[]{nx, ny, d+1, k-1});
                    visited[nx][ny] = k-1;
                }
            }
        }

        return -1;
    }
}