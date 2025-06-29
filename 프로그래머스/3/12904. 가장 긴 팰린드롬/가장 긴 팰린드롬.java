
class Solution {
    public int solution(String s) {
        // 서브스트링 길이
        for (int i = s.length(); i >= 1; i--) {
            // 시작 인덱스
            for (int j = 0; j + i <= s.length(); j++) {
                if (check(s, i, j))
                    return i;
            }
        }

        return -1;
    }

    public static boolean check(String s, int length, int start) {
        int left = start;
        int right = start + length - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}