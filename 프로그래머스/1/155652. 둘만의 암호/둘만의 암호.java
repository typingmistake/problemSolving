import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] answer = new char[s.length()];
        Set<Character> skipList = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            skipList.add(skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            int targetIndex = index;
            int idx = 0;
            char next = ' ';

            while (idx++ < targetIndex) {
                next = add(s.charAt(i), idx);

                if (skipList.contains(next)) {
                    targetIndex++;
                }
            }

            answer[i] = next;
        }

        return new String(answer);
    }

    public static char add(char a, int b) {
        int result = a + b;
        while (result > 'z') {
            result -= 26;
        }
        return (char) result;
    }
}