class Solution {
    static int MAX = 1 * 60 * 60 * 12;
    static int H = 1; // 초당 시침 단위
    static int M = 1 * 12; // 초당 분침 단위
    static int S = 1 * 12 * 60; // 초당 초침 단위

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long t = toSec(h1, m1, s1);
        long d = toSec(h2, m2, s2);
        long[] pos = new long[] { t * H % MAX, t * M % MAX, t * S % MAX };
        int answer = 0;

        if (pos[1] == pos[2] || pos[0] == pos[1])
            answer++;

        while (t != d) {
            answer += check(pos);
            update(pos);
            t += 1;
        }

        return answer;
    }

    public static long toSec(int h, int m, int s) {
        return (h * 60 * 60 + m * 60 + s);
    }

    public static int check(long[] pos) {
        int cnt = 0;

        if (pos[2] < pos[1] && pos[2] + S >= pos[1] + M) {
            cnt++;
        }

        if (pos[2] < pos[0] && pos[2] + S >= pos[0] + H) {
            cnt++;
        }

        // 정오, 자정에 시침과 분침이 겹치는 경우
        if (pos[2] + S == pos[1] + M && pos[1] + M == pos[0] + H) {
            cnt--;
        }

        return cnt;
    }

    public static void update(long[] pos) {
        pos[0] = (pos[0] + H) % MAX;
        pos[1] = (pos[1] + M) % MAX;
        pos[2] = (pos[2] + S) % MAX;
    }
}