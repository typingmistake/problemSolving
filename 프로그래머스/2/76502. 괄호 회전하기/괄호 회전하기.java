import java.util.*;

class Solution {
    Map<Character, Character> map = new HashMap<>();

    public Solution() {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String spinned = s.substring(i, s.length()) + s.substring(0, i);
            if (check(spinned))
                answer++;
        }
        return answer;
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char last = stack.pop();
                if (map.get(last) != c) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}