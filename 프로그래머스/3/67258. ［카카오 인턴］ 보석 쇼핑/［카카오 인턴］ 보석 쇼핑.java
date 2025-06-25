import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];

        Map<String, Integer> gemCnt = new HashMap<>();
        Set<String> uniq = new HashSet<>(Arrays.asList(gems));
        int targetNum = uniq.size();

        int first = 0, last = 0;
        int curr = 0; // 현재 가진 서로 다른 보석의 개수

        while (first <= last && last < gems.length) {
            String right = gems[last];
            gemCnt.put(right, gemCnt.getOrDefault(right, 0) + 1);
            if (gemCnt.get(right) == 1)
                curr++;

            while (curr == targetNum) {
                if (last - first + 1 < len) {
                    answer[0] = first + 1;
                    answer[1] = last + 1;
                    len = last - first + 1;
                }

                String left = gems[first];
                gemCnt.put(left, gemCnt.get(left) - 1);
                if (gemCnt.get(left) == 0)
                    curr--;
                first++; // 왼쪽 포인터 이동
            }

            last++; // 오른쪽 포인터 이동
        }

        return answer;
    }
}