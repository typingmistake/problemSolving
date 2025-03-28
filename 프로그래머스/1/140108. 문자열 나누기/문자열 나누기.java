class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        char x = s.charAt(0);
        int sameCnt = 0;
        int diffCnt = 0;
        
        while (idx < s.length()) {
            if (s.charAt(idx) == x) {
                sameCnt++;
            } else {
                diffCnt++;
            }
            
            if (sameCnt == diffCnt) {
                answer++;
                x = s.charAt(Math.min(idx+1, s.length()-1));
                sameCnt = 0;
                diffCnt = 0;
            }
            
            idx++;
        }
        
        if (sameCnt != 0) {
            answer++;
        }
        
        return answer;
    }
}