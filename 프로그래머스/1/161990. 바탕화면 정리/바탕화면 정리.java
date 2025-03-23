import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String[] row = wallpaper[i].split("");
            for (int j = 0; j < row.length; j++) {
                if (row[j].equals("#")) {
                    list.add(new int[] { i, j });
                }
            }
        }

        int lux = list.get(0)[0];
        int luy = list.get(0)[1];
        int rdx = list.get(0)[0] + 1;
        int rdy = list.get(0)[1] + 1;

        for (int i = 1; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            lux = Math.min(lux, x);
            luy = Math.min(luy, y);
            rdx = Math.max(rdx, x + 1);
            rdy = Math.max(rdy, y + 1);
        }

        return new int[] { lux, luy, rdx, rdy };
    }
}