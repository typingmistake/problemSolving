class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        for(long i = l-1; i < r; i++){
            if(check(i, n)){
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean check(long n, int m){
        while(m-- > 0){
            if(n%5 == 2){
                return false;
            }
            n/=5;
        }
        return true;
    }
}