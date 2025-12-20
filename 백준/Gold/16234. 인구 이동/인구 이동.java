import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(solve(map, N, L, R));
    }
    public static int solve(int[][] map, int N, int L, int R){
        int days = 0;

        while(true){
            boolean isMoved = false;
            boolean[][] visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    List<int[]> union = bfs(new int[]{i, j}, N, L, R, map, visited);
                    if(union.size() == 1) continue;

                    int pop = 0;
                    int cnt = union.size();

                    for(int[] country : union){
                        pop += map[country[0]][country[1]];
                    }

                    for(int[] country : union){
                        map[country[0]][country[1]] = pop / cnt;
                    }

                    isMoved = true;
                }
            }

            if(!isMoved) break;
            days++;
        }

        return days;
    }

    static List<int[]> bfs(int[] start, int N, int L, int R, int[][] map, boolean[][] visited){
        List<int[]> union = new ArrayList<>();
        union.add(start);

        int x = start[0];
        int y = start[1];

        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            int diff = Math.abs(map[x][y] - map[nx][ny]); // 인구 차이

            if(diff < L || diff > R) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            union.addAll(bfs(new int[]{nx, ny}, N, L, R, map, visited));
        }

        return union;
    }
}