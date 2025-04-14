import java.util.*;

class Solution {
    static boolean[][] visited;

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    answer.add(dfs(maps, j, i));
                }
            }
        }

        return answer.isEmpty() ? new int[] { -1 }
                : answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    static int dfs(String[] maps, int x, int y) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { x, y, });
        visited[y][x] = true;
        result += Integer.parseInt(maps[y].charAt(x) + "");

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int currX = curr[0];
            int currY = curr[1];

            int[][] nexts = new int[][] {
                    { currX + 1, currY },
                    { currX - 1, currY },
                    { currX, currY + 1 },
                    { currX, currY - 1 } };

            for (int[] next : nexts) {
                int nextX = next[0];
                int nextY = next[1];

                if (nextX < 0 || nextY < 0 || nextX >= maps[0].length()
                        || nextY >= maps.length) {
                    continue;
                }

                if (!visited[nextY][nextX] && maps[nextY].charAt(nextX) != 'X') {
                    visited[nextY][nextX] = true;
                    stack.push(new int[] { nextX, nextY });
                    result += Integer.parseInt(maps[nextY].charAt(nextX) + "");
                }
            }
        }

        return result;
    }

}