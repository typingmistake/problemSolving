import java.util.Arrays;

class Solution {
    static long limit;
    static int[] diffs;
    static int[] times;
    static int[] spends;

    public int solution(int[] diffs, int[] times, long limit) {
        Solution.limit = limit;
        Solution.diffs = diffs;
        Solution.times = times;
        Solution.spends = new int[times.length];

        spends[0] = times[0];
        for (int i = 1; i < times.length; i++) {
            spends[i] = times[i - 1] + times[i];
        }

        int start = Arrays.stream(diffs).min().getAsInt();
        int end = Arrays.stream(diffs).max().getAsInt();

        return binary(start, end);
    }

    public int binary(int start, int end) {
        if (start == end) {
            return start;
        }

        int m = (start + end) / 2;
        long res = calc(m);

        if (res == limit) {
            return m;
        } else if (res < limit) {
            return binary(start, m);
        } else {
            return binary(m + 1, end);
        }
    }

    public long calc(int level) {
        long res = 0;
        for (int i = 0; i < diffs.length; i++) {
            res += Math.max(0, diffs[i] - level) * spends[i] + times[i];
        }

        return res;
    }
}