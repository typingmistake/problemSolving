import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> partA = new HashMap<>();
        Map<Integer,Integer> partB = new HashMap<>();
        for(int t : topping){
            partB.put(t, partB.getOrDefault(t, 0) + 1);
        }
        for(int i = 0; i < topping.length; i++){
            move(partA, partB, topping[i]);
            if(partA.size() == partB.size()){
                answer++;
            }
        }
        return answer;
    }
    
    // partB -> partA
    public void move(Map<Integer,Integer> partA, Map<Integer,Integer> partB, int item){
        partB.put(item, partB.get(item) - 1);
        if(partB.get(item) == 0){
            partB.remove(item);
        }
        
        partA.put(item, partA.getOrDefault(item, 0) + 1);
    }
}