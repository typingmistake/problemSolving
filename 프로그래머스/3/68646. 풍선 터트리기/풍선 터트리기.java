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
            dpR[n-1-i] = Math.min(dpR[n-i], a[n-1-i]);
        }
        
        int answer = 2;
        for(int i = 1; i < n-1; i++){
            if(dpL[i-1] >= a[i] || dpR[i+1] >= a[i])
                answer++;
        }
        
        return answer;
    }
}