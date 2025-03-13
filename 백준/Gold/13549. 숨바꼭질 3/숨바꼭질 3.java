import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solve(N, K)));
        bw.newLine();
        bw.flush();
    }

    public static int solve(int N, int K) {
        int maximum = 100000;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[maximum + 1];
        Arrays.fill(visited, false);
        visited[N] = true;
        queue.offer(new int[] { N, 0 });

        while (queue.size() > 0) {
            int[] curr = queue.poll();
            int pos = curr[0];
            int cost = curr[1];

            if (pos == K) {
                return cost;
            }
            int[] next = new int[2];
            next[0] = pos - 1;
            next[1] = pos + 1;

            while (0 < pos && pos * 2 <= maximum) {
                pos *= 2;
                if (pos <= maximum && !visited[pos]) {
                    queue.add(new int[] { pos, cost });
                    visited[pos] = true;
                }
            }

            for (int i = 0; i < 2; i++) {
                if (next[i] >= 0 && next[i] <= maximum && !visited[next[i]]) {
                    queue.add(new int[] { next[i], cost + 1 });
                    visited[next[i]] = true;
                }
            }
        }
        return -1;
    }
}