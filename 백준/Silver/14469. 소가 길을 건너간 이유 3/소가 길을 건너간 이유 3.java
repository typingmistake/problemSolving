import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            events.add(new int[]{a, b});
        }

        events.sort((a, b) -> a[0]-b[0]);

        int t = 0;
        int idx = 0;

        while(idx < N){
            int[] event = events.get(idx);

            if(t < event[0]){
                t = event[0];
                continue;
            }

            t += event[1];
            idx++;
        }

        System.out.println(t);
    }
}