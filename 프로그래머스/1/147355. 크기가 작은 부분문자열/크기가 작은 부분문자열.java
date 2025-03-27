import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long target = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - p.length(); i++){
            long sub = Long.parseLong(t.substring(i, i + p.length()));
            if(sub <= target){
                answer++;
            }
        }
        return answer;
    }
}