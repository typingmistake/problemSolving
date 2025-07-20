public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n > 0) {
            // 순간이동 역행
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            
            // 점프 역행
            n--;
            answer++;
        }
        
        return answer;
    }
}