import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int c = 0; // 연속 회복 횟수
        int m = 0; // 몇번째 몬스터 공격인지
        int h = health;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[m][0]) {
                h -= attacks[m++][1];
                c = 0;
                if (h <= 0) {
                    return -1; // 죽음
                }
                continue;
            }

            h += x;
            if (++c == t) {
                h += y;
                c = 0;
            }

            h = Math.min(h, health); // 최대 체력은 health
        }

        return h;
    }
}