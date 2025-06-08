class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if(n <= 2)
            return n;
        
        int[] dpL = new int[n];
        int[] dpR = new int[n];
        dpL[0] = a[0];
        dpR[n-1] = a[n-1];
        
        for(int i = 1; i < n; i++){
            dpL[i] = Math.min(dpL[i-1], a[i]);
        }
        for(int i = n-2; i >= 0; i--){
            dpR[i] = Math.min(dpR[i+1], a[i]);
        }
        
        int answer = 2;
        for(int i = 1; i < n-1; i++){
            int cnt = 0;
            if(dpL[i-1] < a[i])
                cnt++;
            if(dpR[i+1] < a[i])
                cnt++;
            if(cnt < 2)
                answer++;
        }
        return answer;
    }
}