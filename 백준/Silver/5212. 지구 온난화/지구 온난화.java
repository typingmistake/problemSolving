import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        char[][] map = new char[R][C];

        for(int i = 0; i < R; i++){
            line = sc.readLine().split(" ");
            for(int j = 0; j < C; j++){
                map[i][j] = line[0].charAt(j);
            }
        }

        // 육지 좌표 체크
        List<int[]> lands = new ArrayList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'X'){
                    lands.add(new int[]{i, j}); // 육지 y, x
                }
            }
        }

        List<int[]> toRemove = new ArrayList<>();
        // 잠기는 섬 체크 후 리스트에서 제거
        for(int[] land : lands){
            int x = land[1], y = land[0];
            int cnt = 0;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(ny < 0 || ny >= R || nx < 0 || nx >= C ) {
                    cnt++;
                    continue;
                };
                if(map[ny][nx] == '.') cnt++;
            }

            if(cnt >= 3){
                toRemove.add(new int[]{y, x});
            }
        }

        for(int[] land : toRemove) {
            int x = land[1], y = land[0];
            map[y][x] = '.';
        }

        lands.removeIf(land -> map[land[0]][land[1]] == '.');
        int minY = R, maxY = 0, minX = C, maxX = 0;

        for(int[] land : lands){
            int x = land[1], y = land[0];
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }

        for(int i = minY; i <= maxY; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = minX; j <= maxX; j++){
                sb.append(map[i][j]);
            }
            System.out.println(sb.toString());
        }
    }
}