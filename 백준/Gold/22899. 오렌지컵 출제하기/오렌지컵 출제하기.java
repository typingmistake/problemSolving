import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] arr = new int[N][2];
        String[] idx = br.readLine().split(" ");
        String[] time = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(idx[i]);
            arr[i][1] = Integer.parseInt(time[i]);
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        Map<Integer, Queue<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int id = arr[i][0];
            int t = arr[i][1];
            map.putIfAbsent(id, new ArrayDeque<>());
            map.get(id).add(t);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long result = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            for (int key : map.keySet()) {
                Queue<Integer> q = map.get(key);
                if (q.isEmpty()) continue;
                int t = q.poll();
                
                pq.add(t);
                result += t;
                
                if (pq.size() > K) {
                    result -= pq.poll();
                }
            }
            sb.append(pq.size() >= K ? result : -1).append(" ");
        }
        
        System.out.print(sb);
    }
}