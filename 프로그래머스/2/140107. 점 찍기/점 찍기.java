class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        // x축 기준으로 계산
        int x = 0;
        while(x <= d){
            answer += (int)Math.sqrt(Math.pow(d,2) - Math.pow(x,2)) / k + 1 ;
            
            x += k;
        }
        return answer;
    }
}