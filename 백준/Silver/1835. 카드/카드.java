import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[N];

        for(int i=0; i<N; i++){
            dq.add(i);
        }

        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++){
                dq.addLast(dq.pollFirst());
            }
            result[dq.pollFirst()] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}