import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long B = Long.parseLong(input[0]);
        long N = Long.parseLong(input[1]);
        long M = Long.parseLong(input[2]);

        Map<String, Long> map = new HashMap<>();

        while(N-- > 0){
            String[] line = br.readLine().split(" ");
            String n = line[0];
            long p = Long.parseLong(line[1]);

            map.put(n, p);
        }

        while(M-- > 0){
            String n = br.readLine().strip();
            B-= map.get(n);
            if(B < 0){
                System.out.println("unacceptable");
                return;
            }
        }

        System.out.println("acceptable");
    }
}