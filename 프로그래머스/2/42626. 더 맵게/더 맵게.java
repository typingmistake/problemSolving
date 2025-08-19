import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for(int p : scoville){
            pq.add(p);
        }
        
        while(pq.peek() < K && pq.size() >= 2){
            pq.add(mix(pq.remove(), pq.remove()));
            answer++;
        }
        
        if(pq.peek() < K){
            return -1;
        }
        
        
        return answer;
    }
    
    public static int mix(int a, int b){
        return a + b*2;
    }
}