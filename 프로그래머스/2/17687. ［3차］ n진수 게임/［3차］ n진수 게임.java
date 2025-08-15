import java.util.*;

class Solution {
    static String digits = "0123456789ABCDEF";
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int cnt = 0;
        int num = 0;
        p--;
        List<Character> list = new ArrayList<>();
        while (cnt <= m * t) {
            for (char c : convertBase(num++, n).toCharArray()) {
                list.add(c);
                cnt++;
            }
        }
        cnt = 0;
        while (cnt++ < t) {
            answer += list.get(p);
            p += m;
        }
        return answer;
    }

    public static String convertBase(int num, int m) {
        if (num == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(digits.charAt(num%m));
            num /= m;
        }

        return sb.reverse().toString();
    }
}