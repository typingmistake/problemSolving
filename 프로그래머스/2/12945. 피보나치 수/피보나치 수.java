class Solution {
    static int MOD = 1234567;

    public int solution(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }

        return fibo[n];
    }
}