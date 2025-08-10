import java.util.*;

class Solution {
    static int MAX = 10_000_000;

    public int solution(String numbers) {
        boolean[] isPrime = findPrimes(MAX);
        String[] arr = numbers.split("");
        Set<Integer> visited = new HashSet<>();
        return brute(0, isPrime, 0, arr, visited);
    }

    static int brute(int used, boolean[] isPrime, int curr, String[] arr, Set<Integer> visited) {
        int result = 0;
        if (curr >= 2 && isPrime[curr]) {
            if (!visited.contains(curr)) {
                visited.add(curr);
                System.out.println(curr);
                result++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if ((used & (1 << i)) != 0)
                continue;

            result += brute(used | (1 << i), isPrime, curr * 10 + Integer.parseInt(arr[i]), arr, visited);
        }

        return result;
    }

    static boolean[] findPrimes(int max) {
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < max / 2; i++) {
            if (!isPrime[i])
                continue;
            int mul = 2;
            while (mul * i < max) {
                isPrime[mul * i] = false;
                mul++;
            }
        }

        return isPrime;
    }
}