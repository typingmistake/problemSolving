import java.util.*;

class Solution {
    int solution(int[][] land) {
        int size = 4;
        
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < size; j++){
                int max = 0;
                for(int k = 0; k < size; k++){
                    if(j==k) continue;
                    max = Math.max(max, land[i-1][k]);
                }
                land[i][j] += max;
            }
        }
        

        return Arrays.stream(land[land.length-1]).max().orElse(0);
    }
}