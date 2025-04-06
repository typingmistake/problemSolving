class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = sequence.length;
        int sum = sequence[len-1];

        int curr_start = len-1;
        int curr_end = len-1;
        int res_start = len-1;
        int res_end = len-1;
        
        if(sum == k && len >= (curr_end-curr_start+1)){
                len = curr_end-curr_start+1;
                res_start = curr_start;
                res_end = curr_end;
            }
        
        while(curr_start > 0){
            sum += sequence[--curr_start];
            
            while(sum > k){
                sum -= sequence[curr_end--];
            }
            
            if(sum == k && len >= (curr_end-curr_start+1)){
                len = curr_end-curr_start+1;
                res_start = curr_start;
                res_end = curr_end;
            }
        }
        return new int[]{res_start,res_end};
    }
}