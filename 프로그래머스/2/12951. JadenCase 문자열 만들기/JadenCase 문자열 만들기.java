class Solution {
    public String solution(String s) {
        boolean check = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                check = true;
            } else {
                if (check) {
                    check = false;
                    s = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
                } else {
                    s = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i + 1);
                }
            }
        }

        return s;
    }
}