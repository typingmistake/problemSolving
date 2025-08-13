import java.util.*;

class Solution {
    static int SIZE = 5;
    public int solution(String dirs) {
        int answer = 0;
        Set<String> visited = new HashSet<>();
        Map<Character, int[]> map = Map.of(
            'U', new int[]{1,0},
            'D', new int[]{-1,0},
            'R', new int[]{0,1},
            'L', new int[]{0,-1}
        );
        
        int[] curr = new int[]{0, 0};
        char[] cmds = dirs.toCharArray();
        
        for(Character cmd : cmds){
            int[] diff = map.get(cmd);
            int[] next = new int[]{curr[0]+diff[0], curr[1]+diff[1]};
            if(isInRange(next)){
                visited.add(curr[0] + ":" + next[0] + ":" + curr[1] + ":" + next[1]);
                visited.add(next[0] + ":" + curr[0] + ":" + next[1] + ":" + curr[1]);
                curr = next;
            }
        }
        return visited.size()/2;
    }
    
    public static boolean isInRange(int[] next){
        if(next[0] < -SIZE || SIZE < next[0]){
            return false;
        }
        if(next[1] < -SIZE || SIZE < next[1]){
            return false;
        }
        
        return true;
    }
}