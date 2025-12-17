import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = calcPrime(N);

        for(int n = 2; n <= N; n++){
            if(isPrime[n] && check(n)){
                System.out.println(n);
            }
        }

    }

    public static boolean[] calcPrime(int N){
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i <= N; i++){
            if(!isPrime[i]) continue;
            for(int j = i*i; j <= N; j+=i){
                isPrime[j] = false;
            }
        }

        return isPrime;
    }

    public static boolean check(int n){
        Set<Integer> set = new HashSet<>(); // 이미 본 숫자들

        while(n != 1){
            int next = 0;
            while(n > 0){
                int digit = n % 10;
                n /= 10;
                next += digit * digit;
            }

            if(set.contains(next)) return false; // 사이클 발생
            set.add(next);
            n = next;
        }

        return true; // 상근수
    }
}