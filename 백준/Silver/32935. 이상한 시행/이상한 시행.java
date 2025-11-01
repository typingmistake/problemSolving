import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0;

        for(long num : arr){
            pq.offer(num);
            sum += num;
        }

        while(true){
            long min = pq.remove();
            if(min < -sum){
                pq.add(-sum);
                sum = -min;
                continue;
            }
            break;
        }

        System.out.println(sum);
    }
}