import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(int i = 0; i < n; i++){
            while(!pq.isEmpty()){
                int[] first = pq.peek();
                if(first[1] <= prices[i])
                    break;
                
                answer[first[0]] = i - first[0];
                pq.remove();
            }
            pq.add(new int[]{i, prices[i]});
        }
        while(!pq.isEmpty()){
            int[] removed = pq.remove();
            answer[removed[0]] = n - removed[0] - 1;
        }
        return answer;
    }
}