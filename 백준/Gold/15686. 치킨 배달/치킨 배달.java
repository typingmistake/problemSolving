import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static int answer = Integer.MAX_VALUE; // 전역변수로 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        solve(arr, N, M);

        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
    }

    public static void solve(int[][] arr, int N, int M) {
        ArrayList<int[]> home = new ArrayList<>();
        ArrayList<int[]> chicken = new ArrayList<>();
        ArrayList<int[]> stack = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    home.add(new int[] { i, j });
                } else if (arr[i][j] == 2) {
                    chicken.add(new int[] { i, j });
                }
            }
        }

        comb(stack, chicken, home, M, 0);
    }

    public static void comb(ArrayList<int[]> stack, ArrayList<int[]> chicken, ArrayList<int[]> home, int M, int idx) {
        // M개의 치킨집을 다 선택했을 때
        if (stack.size() == M) {
            answer = Math.min(answer, getChickenDistance(home, stack));
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            stack.add(chicken.get(i)); // i번째를 선택함
            comb(stack, chicken, home, M, i + 1);
            stack.remove(stack.size() - 1); // i번째를 선택하지 않음
        }
    }

    public static int getChickenDistance(ArrayList<int[]> home, ArrayList<int[]> chicken) {
        int totalDistance = 0;
        for (int[] h : home) {
            int minDist = Integer.MAX_VALUE;
            for (int[] c : chicken) {
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minDist = Math.min(minDist, dist);
            }
            totalDistance += minDist;
        }
        return totalDistance;
    }
}