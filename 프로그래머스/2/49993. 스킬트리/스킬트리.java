import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> steps = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            steps.put(skill.charAt(i), i);
        }
        for (String skill_tree : skill_trees) {
            if (isValid(skill, skill_tree, steps))
                answer++;
        }
        return answer;
    }

    public static boolean isValid(String skill, String skill_tree, Map<Character, Integer> steps) {
        int curr = 0;
        for (char c : skill_tree.toCharArray()) {
            int step = steps.getOrDefault(c, -1);

            if (step > curr) {
                return false;
            }

            if (step == curr) {
                curr++;
                continue;
            }
        }

        return true;
    }
}