import java.util.*;

class Solution {
    static float max = Float.MIN_VALUE;
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
        int[] dpA = new int[maxSum + 1];
        dpA[0] = 1;

        boolean[] selectedByA = new boolean[n];
        for (int diceIdx : curr) {
            selectedByA[diceIdx] = true;
        }

        for (int diceIdx : curr) {
            int[] newDpA = new int[maxSum + 1];
            for (int sum = 0; sum <= maxSum; sum++) {
                if (dpA[sum] > 0) {
                    for (int face = 0; face < 6; face++) {
                        int newSum = sum + dice[diceIdx][face];
                        if (newSum <= maxSum) {
                            newDpA[newSum] += dpA[sum];
                        }
                    }
                }
            }
            dpA = newDpA;
        }

        int[] dpB = new int[maxSum + 1];
        dpB[0] = 1; // 초기값

        for (int diceIdx = 0; diceIdx < n; diceIdx++) {
            if (!selectedByA[diceIdx]) {
                int[] newDpB = new int[maxSum + 1];
                for (int sum = 0; sum <= maxSum; sum++) {
                    if (dpB[sum] > 0) {
                        for (int face = 0; face < 6; face++) {
                            int newSum = sum + dice[diceIdx][face];
                            if (newSum <= maxSum) {
                                newDpB[newSum] += dpB[sum];
                            }
                        }
                    }
                }
                dpB = newDpB;
            }
        }

        int wins = 0;
        int ties = 0;
        int loses = 0;

        for (int aSum = 1; aSum <= maxSum; aSum++) {
            if (dpA[aSum] > 0) {
                for (int bSum = 1; bSum <= maxSum; bSum++) {
                    if (dpB[bSum] > 0) {
                        int count = dpA[aSum] * dpB[bSum];
                        if (aSum > bSum) {
                            wins += count;
                        } else if (aSum == bSum) {
                            ties += count;
                        } else {
                            loses += count;
                        }
                    }
                }
            }
        }

        int totalCases = wins + ties + loses;

        float winRate = (float) wins / totalCases;

        if (winRate > max) {
            max = winRate;
            maxArr = new ArrayList<>(curr);
        }
    }
}