import java.io.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i/3)*3 + j/3][num] = true;
                }
            }
        }

        if(solve(0)) System.out.println(sb.toString());
    }

    static boolean solve(int idx) {
        if (idx == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) sb.append(board[i][j]).append(" ");
                sb.append(board[i][8]).append("\n");
            }

            return true;
        }

        int i = idx / 9;
        int j = idx % 9;
        int b = (i/3)*3 + j/3;

        if (board[i][j] != 0) return solve(idx + 1);

        for (int num = 1; num <= 9; num++) {
            if (row[i][num] || col[j][num] || box[b][num]) continue;

            board[i][j] = num;
            row[i][num] = col[j][num] = box[b][num] = true;

            if (solve(idx + 1)) return true;

            board[i][j] = 0;
            row[i][num] = col[j][num] = box[b][num] = false;
        }

        return false;
    }
}