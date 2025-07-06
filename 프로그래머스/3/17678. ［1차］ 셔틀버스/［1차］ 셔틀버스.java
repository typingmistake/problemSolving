import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] res = new int[n];
        int curr = 9 * 60; // 9:00
        for (int i = 0; i < n; i++) {
            res[i] = curr; // 버스 도착시간
            curr += t;
        }

        // 도착 시간 기준 정렬
        Arrays.sort(timetable);

        int idx = 0;
        // 각 버스셔틀 타는 사람들 중 가장 느린 도착시간 계산
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (idx < timetable.length && toMin(timetable[idx]) <= res[i] && cnt < m) {
                cnt++;
                idx++;
            }

            if (cnt == m) {
                res[i] = toMin(timetable[idx-1]) - 1;
            }
        }

        return toString(res[n - 1]);
    }

    public static int toMin(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        String h = st.nextToken();
        String m = st.nextToken();

        return Integer.parseInt(h) * 60 + Integer.parseInt(m);
    }

    public static String toString(int min) {
        return String.format("%02d:%02d", min / 60, min % 60);
    }
}