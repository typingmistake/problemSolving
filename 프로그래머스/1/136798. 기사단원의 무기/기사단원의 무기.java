class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] nums = calc(number);
        
        for(int i=1; i <= number ; i++){
            if(nums[i] <= limit){
                answer+=nums[i];
            }else{
                answer+=power;
            }
        }
        return answer;
    }
    public int[] calc(int number){
        int[] res = new int[number+1];
        for (int i = 1; i <= number; i++) {
            int cur = 1;
            while (i * cur <= number) {
                res[i * cur]++;
                cur++;
            }
        }
        return res;
    }
}