import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> categories = new HashMap<>();
        for(String[] curr : clothes){
            String cat = curr[1];
            categories.put(cat, categories.getOrDefault(cat,0) + 1);
        }
        for(int cnt : categories.values()){
            answer *= cnt + 1;
        }
        return answer - 1;
    }
}