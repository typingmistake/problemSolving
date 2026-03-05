import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int G = Integer.parseInt(input[1]);
        int g = gcd(R, G);

        List<Integer> factors = factors(g);

        for(int f : factors){
            int X = R/f;
            int Y = G/f;
            System.out.println(f + " " + X + " " + Y);
        }
    }

    public static int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static List<Integer> factors(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);

                if (i*i != n) {
                    factors.add(n/i);
                }
            }
        }

        return factors;
    }
}