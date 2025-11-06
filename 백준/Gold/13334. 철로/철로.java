import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        int[][] points = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            points[i][0] = Math.min(n, m);
            points[i][1] = Math.max(n, m);
        }

        int d = Integer.parseInt(br.readLine());

        Arrays.sort(points, (a, b) -> a[1] - b[1]); // 끝나는 점 기준 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 시작점 오름차순

        for(int i = 0; i < N; i++){
            int start = points[i][0];
            int end = points[i][1];

            pq.add(start);
            int curr = end - d; // 현재 구간 시작점

            while(!pq.isEmpty() && pq.peek() < curr){
                pq.remove();
            }

            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }
}