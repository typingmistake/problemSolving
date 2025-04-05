class Solution {
    public long solution(int r1, int r2) {
        long answer = r2 - r1 + 1;

        // sqrt(r2^2 - x^2) <= y <= sqrt(r1^2 - x^2)
        for (int x = 1; x < r2; x++) {
            // y2 = sqrt(r2^2 - x^2)
            long y2 = (long) Math.sqrt((long) r2 * r2 - (long) x * x);
            // y1 = sqrt(r1^2 - x^2)
            long y1;
            if (x < r1) {
                y1 = (long) Math.sqrt((long) r1 * r1 - (long) x * x) == Math.sqrt((long) r1 * r1 - (long) x * x)
                        ? (long) Math.sqrt((long) r1 * r1 - (long) x * x) - 1
                        : (long) Math.sqrt((long) r1 * r1 - (long) x * x);
            } else {
                y1 = 0;
            }
            // y2 - y1
            answer += (y2 - y1);
        }
        return answer * 4;
    }
}