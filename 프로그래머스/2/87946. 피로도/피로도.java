import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        return brute(k, 0, dungeons, 0);
    }
    
    public int brute(int curr, int cnt, int[][] dungeons, int visited){
        int res = cnt;
        for(int i = 0; i < dungeons.length; i++){
            if((visited & (1 << i)) == 0 && curr >= dungeons[i][0]){
                res = Math.max(res, brute(curr - dungeons[i][1], cnt + 1, dungeons, visited | (1 << i)));
            }
        }
        return res;
    }
}