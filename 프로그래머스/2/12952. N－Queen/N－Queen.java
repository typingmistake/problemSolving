import java.util.*;

class Solution {
    static int answer;

    public int solution(int n) {
        answer = 0;
        solve(n, 0, new ArrayList<>());
        
        return answer;
    }

    public static void solve(int n, int curr, List<Integer> arr) {
        if (curr == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(arr, i)) {
                arr.add(i);
                solve(n, curr + 1, new ArrayList<>(arr));
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static boolean check(List<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == target || Math.abs(arr.get(i) - target) == Math.abs(i - arr.size())) {
                return false;
            }
        }
        return true;
    }
}