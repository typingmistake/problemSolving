import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        char ch = 'A';

        // 사전 초기화
        while (ch <= 'Z') {
            dict.put(String.valueOf(ch++), idx++);
        }

        int start = 0; // 글자 시작 위치
        while (start < msg.length()) {
            int end = start + 1; // 글자 끝 위치
            int prev = -1;
            int curr;
            while (end <= msg.length()) {
                // 현재 글자와 다음 글자를 합쳐서 사전에 있는지 확인
                curr = dict.getOrDefault(msg.substring(start, end), -1);
                if (curr != -1) {
                    prev = curr;
                    end++;
                } else {
                    dict.put(msg.substring(start, end), idx++);
                    break;
                }
            }
            answer.add(prev);
            start = end-1; // 다음 글자 시작 위치
        }

        return answer.stream()
                .mapToInt(n -> n)
                .toArray();
    }
}