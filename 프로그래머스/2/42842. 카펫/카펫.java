import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        
        List<Integer> div = new ArrayList<>();
        for (int d = 1; d <= Math.sqrt(yellow); d++) {
            if(yellow%d == 0)
                div.add(d);
        }
        
        for(int d : div){
            int h = d+2;
            int w = (yellow/d)+2;
            if(w*h == sum)
                return new int[]{w, h};
        }
        return answer;
    }
}