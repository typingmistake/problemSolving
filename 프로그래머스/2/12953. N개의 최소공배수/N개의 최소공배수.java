import java.util.*;

class Solution {

    public int solution(int[] arr) {
        int answer = 1;
        Map<Integer, Integer> primes = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            List<int[]> result = prime(arr[i]);

            for (int j = 0; j < result.size(); j++) {
                int[] p = result.get(j);
                if (primes.containsKey(p[0])) {
                    primes.put(p[0], Math.max(primes.get(p[0]), p[1]));
                } else {
                    primes.put(p[0], p[1]);
                }
            }
        }

        for (Integer num : primes.keySet()) {
            int cnt = primes.get(num);
            answer *= Math.pow(num, cnt);
        }

        return answer;
    }

    public static List<int[]> prime(int num) {
        List<int[]> res = new ArrayList<>();
        int m = 2;

        while (num > 1) {
            int cnt = 0;
            while (num % m == 0){
                cnt++;
                num /= m;
            }
            res.add(new int[] { m, cnt });
            m++;
        }

        return res;
    }
}