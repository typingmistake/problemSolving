import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());

        for (String num : phone_book) {
            for (int i = 1; i <= num.length(); i++) {
                String sub = num.substring(0, i);
                if (set.contains(sub))
                    return false;
            }
            set.add(num);
        }

        return true;
    }
}