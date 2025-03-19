import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> point = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            point.put(name[i], yearning[i]);
        }

        int[] answer = Arrays.stream(photo)
                .mapToInt(p -> Arrays.stream(p)
                        .mapToInt(person -> point.getOrDefault(person, 0))
                        .sum())
                .toArray();

        return answer;
    }
}