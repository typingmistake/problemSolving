import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int[] ends = new int[n];
        
        for(int i = 0; i < n; i++){
            ends[i] = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
        }
        
        int i = 0;
        while(i < n) {
            int deployDay = ends[i]; 
            int count = 1;
            i++;
            
            while(i < n && ends[i] <= deployDay) {
                count++;
                i++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}