import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        PriorityQueue<Integer>[] pq = new PriorityQueue[200_001];
        for(int i = 0; i <= 200_000; i++){
            pq[i] = new PriorityQueue<>();
        }

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            for(int j = 1; j <= k; j++){
                int num = Integer.parseInt(input[j]);
                pq[num].add(i);
            }
        }

        int[] answer = new int[N];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < M; i++){
            int num = arr[i];
            if(pq[num].isEmpty()) continue;
            int idx = pq[num].remove();
            answer[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int cnt : answer){
            sb.append(cnt).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}