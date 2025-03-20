import java.util.*;

class Solution {
    static Map<String, int[]> map = Map.of(
            "E", new int[] { 0, 1 },
            "W", new int[] { 0, -1 },
            "S", new int[] { 1, 0 },
            "N", new int[] { -1, 0 });

    public int[] solution(String[] park, String[] routes) {
        int[] pos = new int[2];

        String[][] parkArr = new String[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            parkArr[i] = park[i].split("");

            for (int j = 0; j < parkArr[i].length; j++) {
                if (parkArr[i][j].equals("S")) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");
            int[] move = map.get(split[0]);
            int v = Integer.parseInt(split[1]);
            int[] nextPos = new int[] { pos[0], pos[1] }; // 깊은 복사

            for (int i = 0; i < v; i++) {
                // 한 칸 이동
                nextPos[0] = nextPos[0] + move[0];
                nextPos[1] = nextPos[1] + move[1];

                if (nextPos[0] < 0
                        || nextPos[0] >= parkArr.length
                        || nextPos[1] < 0
                        || nextPos[1] >= parkArr[0].length
                        || parkArr[nextPos[0]][nextPos[1]].equals("X")) {
                    // 다시 원래 위치로
                    nextPos[0] = pos[0];
                    nextPos[1] = pos[1];
                    break;
                }
            }

            // 이동
            pos = nextPos;
        }

        return pos;
    }
}