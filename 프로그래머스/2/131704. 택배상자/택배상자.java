import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        
        for(int num = 1; num <= n+1; num++){
            int target = order[idx];
            while(!stack.isEmpty() && stack.peek() == target){
                answer++;
                target = order[++idx%n];
                stack.pop();
            }
            
            if(target == num){
                answer++;
                idx++;
                continue;
            }
            
            stack.add(num);
        }
        
        return answer;
    }
}