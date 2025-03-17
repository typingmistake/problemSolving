class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] adjs = { { h, w - 1 }, { h, w + 1 }, { h - 1, w }, { h + 1, w } };
        String target = board[h][w];

        for (int[] adj : adjs) {
            int adjH = adj[0];
            int adjW = adj[1];

            if (adjH < 0 || adjH >= board.length || adjW < 0 || adjW >= board[0].length) {
                continue;
            }

            if (board[adjH][adjW].equals(target)) {
                answer++;
            }
        }
        return answer;
    }
}