import java.util.*;

class Solution {
    static int SIZE = 5;
    static int answer = 0;

    static public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        List<Integer> list = new ArrayList<>();
        track(0, n, list, q, ans);
        return answer;
    }

    public static void track(int cur, int n, List<Integer> list, int[][] q, int[] ans) {
        if (list.size() == SIZE) {
            if (check(list.stream().mapToInt(i -> i).toArray(), q, ans)) {
                answer++;
            }
        }

        for (int i = cur + 1; i <= n; i++) {
            list.add(i);
            track(i, n, list, q, ans);
            list.remove(list.size() - 1);
        }

    }

    public static boolean check(int[] nums, int[][] q, int[] ans) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 0; i < ans.length; i++) {
            int cnt = 0;
            for (int j = 0; j < SIZE; j++) {
                if (numSet.contains(q[i][j])) {
                    cnt++;
                }
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }
}