import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        int N = record.length;
        List<String[]> results = new ArrayList<>(); // 아이디, 이벤트
        Map<String, String> userNames = new HashMap<>(); // 아이디, 닉네임

        for(int i = 0; i < N; i++){
            String[] parts = record[i].split(" ");
            String cmd = parts[0];
            String userId = parts[1];

            if(cmd.equals("Enter")){
                userNames.put(userId, parts[2]);
                results.add(new String[]{userId, cmd});
            } else if(cmd.equals("Leave")){
                results.add(new String[]{userId, cmd});
            } else if(cmd.equals("Change")){
                userNames.put(userId, parts[2]);
            }
        }

        List<String> answer = new ArrayList<>();

        for(String[] result : results){
            String userId = result[0];
            String event = result[1];

            if(event.equals("Enter")){
                answer.add(String.format("%s님이 들어왔습니다.", userNames.get(userId)));
            } else if(event.equals("Leave")){
                answer.add(String.format("%s님이 나갔습니다.", userNames.get(userId)));
            }
        }

        return answer.toArray(String[]::new);
    }
}