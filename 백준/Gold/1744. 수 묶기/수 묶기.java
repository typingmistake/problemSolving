import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = 0;

        PriorityQueue<Long> plus = new PriorityQueue<>((a, b) -> Long.compare(b, a)); // 최대 힙
        PriorityQueue<Long> minus = new PriorityQueue<>(); // 최소 힙

        while(N-- > 0) {
            long n = Long.parseLong(br.readLine());
            if(n > 1) plus.add(n);
            else if(n <= 0) minus.add(n);
            else ans+= n;
        }

        while(plus.size() >= 2){
            long a = plus.remove();
            long b = plus.remove();

            ans += (a * b);
        }

        if(!plus.isEmpty()){
            ans += plus.remove();
        }

        while (minus.size() >= 2){
            long a = minus.remove();
            long b = minus.remove();

            ans += (a * b);
        }

        if(!minus.isEmpty()){
            ans += minus.remove();
        }

        System.out.println(ans);
    }
}