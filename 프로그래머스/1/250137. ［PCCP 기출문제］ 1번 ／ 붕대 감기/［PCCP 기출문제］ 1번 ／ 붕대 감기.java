class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int prev = 0; // 이전 공격 시간

        for(int[] attack : attacks){
            // 회복
            int t = attack[0] - prev - 1;
            prev = attack[0];
            
            int add =  t*bandage[1] + bandage[2] * (t / bandage[0]);
            hp = Math.min(hp+add, health);
            
            // 공격
            hp -= attack[1];
            
            // 체크
            if(hp <= 0){
                return -1;
            }
        }
        
        return hp;
    }
}