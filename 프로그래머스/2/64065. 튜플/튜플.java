import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] parts = s.substring(2, s.length() - 2).split("\\},\\{");
        List<int[]> list = new ArrayList<>();

        for (String part : parts) {
            String[] tokens = part.split(",");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
            list.add(arr);
        }

        list.sort((a, b) -> a.length - b.length); // 길이 짧은 기준으로 정렬
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[list.size()];

        int idx = 0;
        for (int[] arr : list) {
            for (int num : arr) {
                if (!set.contains(num)) {
                    set.add(num);
                    answer[idx++] = num;
                }
            }
        }

        return answer;
    }
}