import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1; // 1분 이상
        long end = Arrays.stream(times).max().getAsInt() * (long) n; // 최대 시간
        while (start <= end) {
            if (start == end) {
                answer = start;
                break;
            }

            long piv = (start + end) / 2; // 중간값

            if (calc(piv, times) >= n) {
                end = piv;
            } else {
                start = piv + 1;
            }
        }
        return answer;

    }

    public static long calc(long p, int[] times) {
        long cnt = 0;
        for (int time : times) {
            cnt += p / time; // 각 심사관이 처리할 수 있는 사람 수
        }
        return cnt;
    }
}