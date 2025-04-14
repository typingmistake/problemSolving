import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[][] book_time) {
        int[] time = new int[24 * 60 + 10];
        for (String[] book : book_time) {
            int start = getMin(book[0]);
            int end = getMin(book[1]) + 10;
            for (int i = start; i < end; i++) {
                time[i]++;
            }
        }
        return Arrays.stream(time).max().getAsInt();
    }

    public static int getMin(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        return hour * 60 + minute;
    }
}
