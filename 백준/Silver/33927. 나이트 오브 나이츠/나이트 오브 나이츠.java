import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {-1, 1, -1, 1, 2, -2, 2, -2};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(solve(0, 0, N));
    }

    public static int solve(int pos, int point, int N){
        boolean canMove = false;

        int val = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!check(pos, i, j, N)) continue;
                canMove = true;
                int npos = pos | (1 << (i * N + j));
                int npoint = point + map[i][j];
                val = Math.max(val, solve(npos, npoint, N));
            }
        }

        if(!canMove){
            return point;
        }

        return val;
    }

    public static boolean check(int pos, int x, int y, int N){
        if((pos & (1 << (x * N + y))) != 0) return false;

        for(int d = 0; d < 8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if((pos & (1 << (nx * N + ny))) != 0){
                return false; // 충돌하는 말이 존재
            }
        }
        return true;
    }
}