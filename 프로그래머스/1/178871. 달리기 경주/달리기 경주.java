import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length;i++){
            map.put(players[i],i);
        }
        for(String call : callings){
            int idx = map.get(call);
            String p1 = players[idx];
            String p2 = players[idx-1];
            
            players[idx] = p2;
            players[idx-1] = p1;
            
            map.put(p1,idx-1);
            map.put(p2,idx);
        }

        return players;
    }
}