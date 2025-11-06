class Solution {
    public int solution(int[] money) {
        int N = money.length;
        int[] dp1 = new int[N]; // 첫 번째 집 선택
        int[] dp2 = new int[N]; // 첫 번째 집 선택 안함

        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[1] = money[1];

        for(int i = 2; i < N-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        // 마지막 집 처리
        dp2[N-1] = Math.max(dp2[N-2], dp2[N-3] + money[N-1]);

        return Math.max(dp1[N-2], dp2[N-1]);
    }
}