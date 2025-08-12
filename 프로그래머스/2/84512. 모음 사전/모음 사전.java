import java.util.*;

class Solution {

    public int solution(String word) {
        int answer = 0;
        Map<Character, Integer> map = Map.of(
                'A', 0,
                'E', 1,
                'I', 2,
                'O', 3,
                'U', 4);
        
        for(int i = 0; i < word.length(); i++){
            // 각 자리수별 가능한 집합 크기
            int mul = 1;
            for(int j = 1; j <= 4-i; j++){
                mul += (int)Math.pow(5, j);
            }
            
            answer += map.get(word.charAt(i)) * mul + 1;
        }
        
        return answer;
        
    }
}