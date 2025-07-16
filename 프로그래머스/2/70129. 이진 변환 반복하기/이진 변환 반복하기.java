
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int cnt = getCount(s);
            answer[1] += cnt;

            s = toBin(s.length() - cnt);
            answer[0]++;
        }
        return answer;
    }

    public static int getCount(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                cnt++;
        }
        return cnt;
    }

    public static String toBin(int l) {
        String res = "";
        while (l != 0) {
            res += Integer.toString(l % 2);
            l /= 2;
        }
        StringBuilder sb = new StringBuilder(res);

        return sb.reverse().toString();

    }
}