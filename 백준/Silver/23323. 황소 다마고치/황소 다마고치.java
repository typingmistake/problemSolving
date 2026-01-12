import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String[] input = br.readLine().split(" ");
            long N = Long.parseLong(input[0]);
            long M = Long.parseLong(input[1]);

            long day = 0;

            while(N > 0){
                N/=2;
                day++;
            }

            System.out.println(day+M);

        }
    }
}