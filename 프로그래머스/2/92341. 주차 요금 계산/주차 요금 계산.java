import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            int min = Integer.parseInt(parts[0].substring(0, 2)) * 60 + Integer.parseInt(parts[0].substring(3, 5));
            String num = parts[1];

            if (parts[2].equals("IN")) {
                inTimeMap.put(num, min);
            } else {
                // 출차 시 총 주차 시간 계산
                totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + (min - inTimeMap.get(num)));
                inTimeMap.remove(num);
            }
        }

        // 입차 후 출차 기록이 없는 차량 처리
        for (String num : inTimeMap.keySet()) {
            totalTimeMap.put(num, totalTimeMap.getOrDefault(num, 0) + (23 * 60 + 59 - inTimeMap.get(num)));
        }

        ArrayList<String> nums = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(nums);
        int[] answer = new int[nums.size()];

        // 요금 계산
        for (int i = 0; i < nums.size(); i++) {
            String num = nums.get(i);
            int totalTime = totalTimeMap.get(num);

            // 기본 요금 이하인 경우
            if (totalTime <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + (int) Math.ceil((totalTime - fees[0]) / (double) fees[2]) * fees[3];
            }
        }

        return answer;
    }
}