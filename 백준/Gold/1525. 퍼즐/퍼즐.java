import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> visited = new HashSet<>(); // 방문한 표 상태 저장
        String target = ""; // 목표 상태

        for(int i = 0; i < 3; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < line.length; j++){
                target += line[j];
            }
        }

        Queue<String[]> q = new ArrayDeque<>();
        visited.add("123456780");
        q.offer(new String[]{"123456780", "0"}); // 상태, 이동 횟수

        while(!q.isEmpty()){
            String[] arr = q.poll();
            String curr = arr[0];
            int cost = Integer.parseInt(arr[1]);

            if(curr.equals(target)){
                System.out.println(cost);
                return;
            }

            int empty = curr.indexOf('0');
            int x = empty%3, y = empty/3;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                int nidx = ny * 3 + nx;

                // 다음 상태 생성
                char[] nextArr = curr.toCharArray();
                nextArr[empty] = nextArr[nidx];
                nextArr[nidx] = '0';
                String next = new String(nextArr);

                if(visited.contains(next)) continue;
                q.offer(new String[]{next, String.valueOf(cost + 1)});
                visited.add(next);
            }

        }

        System.out.println(-1);
    }


}