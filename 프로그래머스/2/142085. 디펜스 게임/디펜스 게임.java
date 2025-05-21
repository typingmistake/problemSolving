import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < enemy.length; i++){
            pq.add(enemy[i]);
            
            // 방어 못하면 찬스 사용
            while((k > 0) && !pq.isEmpty() && (n - enemy[i] < 0)){
                k--;
                n += pq.remove();
            }
            // 찬스를 사용해서 방어 성공
            if(n - enemy[i] >= 0){
                n -= enemy[i];
            }else{
                return i;
            }
        }
        return enemy.length;
    }
}