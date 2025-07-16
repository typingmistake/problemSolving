class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int q = n/i;
            int r = n%i;
            int a = q - (i-1)/2; // 시작점
            
            if(a <= 0)
                break;
            
            if((i%2 == 1 && r == 0) || (i%2 == 0 && r == i/2)){
                answer++;
            }
        }
        
        return answer;
    }
}