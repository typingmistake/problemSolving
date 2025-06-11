class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int m = s/n;
        int p = s%n;
        
        if(m == 0)
            return new int[]{-1};
        
        for(int i = n-1; i >= 0; i--){
            if(p-- > 0){
                answer[i] = m+1;
                continue;
            }
            answer[i] = m;
        }
        
        return answer;
    }
}