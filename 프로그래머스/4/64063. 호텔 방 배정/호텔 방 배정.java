import java.util.*;

class Solution {
    Map<Long, Long> rooms = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];

        for (int i = 0; i < len; i++) {
            answer[i] = findRoom(room_number[i]);
        }
        return answer;
    }

    public long findRoom(long num) {
        if (rooms.containsKey(num)) {
            long nextRoom = findRoom(rooms.get(num));
            rooms.put(num, nextRoom + 1);
            return nextRoom;
        }

        rooms.put(num, num + 1);
        return num;
    }
}