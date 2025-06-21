class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int end = 0;
        int start = 0;
        
        for(int station: stations){
            start = station - w;
            answer += calc(start-end-1, 2*w+1);
            end = station + w;
        }
        
        return answer + calc(n-end, 2*w+1);
    }
    
    public int calc(int n, int w){
        if(n<=0)
            return 0;
        
        return n%w == 0 ? n/w : (n/w)+1;
    }
}