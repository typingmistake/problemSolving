import java.util.*;

class Solution {
    List<String> result;

    public int solution(int n) {
        int answer = 0;
        result = new ArrayList<>();
        solve(n, 0, 0, "");
        return result.size();
    }

    public void solve(int n, int l, int r, String s) {
        // 범위를 벗어나거나, 올바르지 않은 괄호가 형성된 경우 가지치기
        if (l > n || r > n || l < r)
            return;
        if (l == n && r == n) {
            result.add(s);
            return;
        }

        solve(n, l + 1, r, s + "(");
        solve(n, l, r + 1, s + ")");
    }
}