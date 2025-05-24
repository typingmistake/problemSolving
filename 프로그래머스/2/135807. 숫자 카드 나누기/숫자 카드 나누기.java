import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = Math.max(find(arrayA, arrayB), answer);
        answer = Math.max(find(arrayB, arrayA), answer);
        return answer;
    }

    // arrA가 가진 모든 숫자를 나눌 수 있고, arrB가 가진 어떤 숫자도 나눌 수 없는 가장 큰 수
    public static int find(int[] arrA, int[] arrB) {
        Map<Integer, Integer> primes = getPrime(arrA[0]);
        int result = 1;

        for (int i = 1; i < arrA.length; i++) {
            List<Integer> removed = new ArrayList<>();

            for (Integer key : primes.keySet()) {
                int cnt = primes.get(key);
                while (cnt > 0) {
                    if (arrA[i] % Math.pow(key, cnt) == 0) {
                        break;
                    }
                    cnt--;
                }

                if (cnt == 0) {
                    removed.add(key);
                    continue;
                }

                primes.put(key, cnt);
            }

            for (Integer key : removed) {
                primes.remove(key);
            }
        }

        for (Integer key : primes.keySet()) {
            result *= Math.pow(key, primes.get(key));
        }

        for (int i = 0; i < arrB.length; i++) {
            if (arrB[i] % result == 0) {
                return 0;
            }
        }

        return result;
    }

    // 소인수분해
    public static Map<Integer, Integer> getPrime(int num) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                result.put(i, result.getOrDefault(i, 0) + 1);
                num /= i;
            }
            if (num == 1) {
                break;
            }
        }
        if (num != 1) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }

        return result;
    }

}