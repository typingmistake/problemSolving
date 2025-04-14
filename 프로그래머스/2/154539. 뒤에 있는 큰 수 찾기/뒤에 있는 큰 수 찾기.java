import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int curr = stack.pop();
                if (curr > numbers[i]) {
                    answer[i] = curr;
                    stack.push(curr);
                    break;
                }
            }
            stack.add(numbers[i]);
        }
        return answer;
    }
}