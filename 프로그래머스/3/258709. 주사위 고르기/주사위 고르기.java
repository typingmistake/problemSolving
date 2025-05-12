import java.util.*;

class Solution {
    static int max = Integer.MIN_VALUE;
    static int[][] dice;
    static List<Integer> maxArr;
    static int n;
    static int maxSum;

    public int[] solution(int[][] dice) {
        n = dice.length;
        Solution.dice = dice;
        maxArr = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        maxSum = 6 * n / 2 * 100;
        solve(curr, 0);

        int[] result = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            result[i] = maxArr.get(i) + 1;
        }
        return result;
    }

    public static void solve(List<Integer> curr, int idx) {
        if (curr.size() == n / 2) {
            update(curr);
            return;
        }

        for (int i = idx; i < n; i++) {
            curr.add(i);
            solve(curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void update(List<Integer> curr) {
        int[] dpA = new int[maxSum + 1]; // A 경우의 수
        int[] dpB = new int[maxSum + 1]; // B 경우의 수
        dpA[0] = 1;
        dpB[0] = 1;

        for (int diceIdx : curr) {
            int[] tmp = new int[maxSum + 1];

            for (int i = maxSum; i >= 0; i--) {
                if (dpA[i] > 0) {
                    for (int j = 0; j < 6; j++) {
                        if (i + dice[diceIdx][j] <= maxSum) {
                            tmp[i + dice[diceIdx][j]] += dpA[i];
                        }
                    }
                }
            }
            dpA = tmp;
        }

        List<Integer> currB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!curr.contains(i)) {
                currB.add(i);
            }
        }

        for (int diceIdx : currB) {
            int[] tmp = new int[maxSum + 1];

            for (int i = maxSum; i >= 0; i--) {
                if (dpB[i] > 0) {
                    for (int j = 0; j < 6; j++) {
                        if (i + dice[diceIdx][j] <= maxSum) {
                            tmp[i + dice[diceIdx][j]] += dpB[i];
                        }
                    }
                }
            }

            dpB = tmp;
        }

        int[] countSum = new int[maxSum + 1];
        int sum = 0;
        for (int i = 1; i <= maxSum; i++) {
            countSum[i] = sum;
            sum += dpB[i];
        }

        int wins = 0;
        for (int i = 1; i <= maxSum; i++) {
            wins += dpA[i] * countSum[i];
        }

        if (wins > max) {
            max = wins;
            maxArr = new ArrayList<>(curr);
        }
    }
}