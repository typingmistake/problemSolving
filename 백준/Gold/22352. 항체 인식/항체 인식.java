import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] board = new int[N][M];
        int[][] target = new int[N][M];

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++){
            target[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean result = solve(board, target, N, M);

        System.out.println(result ? "YES" : "NO");
    }
    public static boolean solve(int[][] board, int[][] target, int N, int M){
        boolean changed = false; // 변화가 있었는지 여부
        Set<String> visited = new HashSet<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == target[i][j]) continue;
                if(changed) return false;
                changed = true;

                Queue<int[]> q = new ArrayDeque<>();
                visited.add(i + " " + j);
                q.add(new int[]{i, j});

                while(!q.isEmpty()){
                    int[] curr = q.remove();
                    int y = curr[0];
                    int x = curr[1];

                    for(int k = 0; k < 4; k++){
                        int nx = x+dx[k];
                        int ny = y+dy[k];

                        if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                        if(board[ny][nx] != board[i][j]) continue;
                        if(visited.contains(ny + " " + nx)) continue;

                        board[ny][nx] = target[i][j]; // 전파
                        visited.add(ny + " " + nx);
                        q.add(new int[]{ny, nx});
                    }
                }

                board[i][j] = target[i][j];
            }
        }
        
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}