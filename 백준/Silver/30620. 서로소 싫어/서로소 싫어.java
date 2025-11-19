import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);

        long d = getDiv(a);
        long n = 1;
        long c;

        System.out.println(2);

        while(true){
            c = a+d*n;

            if(check(c, Math.abs(b-c))){
                System.out.println(d*n);
                System.out.println(b-c);
                return;
            }

            n+=1;
        }
    }

    public static long getDiv(long a){
        for(long i = 2; i * i <= a; i++){
            if(a % i == 0) return i;
        }

        return a;
    }

    // 서로소가 아니라면 true
    public static boolean check(long a, long b){
        if(a==0 || b==0) return false;
        
        long r;

        while(b > 0){
            r = a % b;
            a = b;
            b = r;
        }

        return a!=1;
    }
}