
import java.util.Arrays;

class Solution {
    public String solution(long n, String[] bans) {
        // 글자 수가 적은 주문부터 먼저 기록된다.
        // 글자 수가 같다면, 사전 순서대로 기록된다.
        Arrays.sort(bans, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        for (String ban : bans) {
            if (getInt(ban) > n) {
                break;
            }
            n++;
        }

        return getString(n);
    }

    public static String getString(long n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            char c = (char) ('a' + n % 26);
            sb.append(c);
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public static long getInt(String s) {
        long res = 0;
        long curr = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'a' + 1) * curr;
            curr *= 26;
        }

        return res;
    }
}