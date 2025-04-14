import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    static int bfs(int start, int target, int n){
        boolean[] visited = new boolean[target+1];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{start, 0});
        visited[start] = true;
        
        while(!dq.isEmpty()){
            int[] curr  = dq.removeFirst();
            int num = curr[0];
            
            if(num == target){
                return curr[1];
            }
            
            int[] nexts = new int[]{num+n, num*2, num*3};
            for(int next : nexts){
                if(next > target || visited[next]){
                    continue;
                }
                dq.add(new int[]{next, curr[1]+1});
                visited[next] = true;
            }
        }
        
        return -1;
    }
}