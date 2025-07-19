import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}