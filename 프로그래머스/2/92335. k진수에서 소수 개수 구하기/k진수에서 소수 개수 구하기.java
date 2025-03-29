
class Solution {
    public int solution(int n, int k) {
        String num = convert(n, k);
        String[] targets = num.split("0");
        int answer = 0;

        for (String target : targets) {
            if (target.equals("")) {
                continue;
            }
            if (isPrime(target)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(String n) {
        long num = Long.parseLong(n);
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }

        return sb.toString();
    }
}