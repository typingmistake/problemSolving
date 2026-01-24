import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String[] idx = br.readLine().split(" ");
        String[] time = br.readLine().split(" ");

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int id = Integer.parseInt(idx[i]);
            int t = Integer.parseInt(time[i]);

            map.putIfAbsent(id, new ArrayList<>());
            map.get(id).add(t);
        }

        // 레벨별 그룹화
        List<List<Integer>> levels = new ArrayList<>();
        // 최대 레벨 N
        for (int i = 0; i < N; i++) levels.add(new ArrayList<>());

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                levels.get(i).add(list.get(i));
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long result = 0;
        StringBuilder sb = new StringBuilder();

        for (int L = 1; L <= N; L++) {
            for (int t : levels.get(L - 1)) {
                if (pq.size() < K || pq.peek() > t) {
                    pq.add(t);
                    result += t;
                    if (pq.size() > K) {
                        result -= pq.poll();
                    }
                }
            }
            sb.append(pq.size() >= K ? result : -1).append(" ");
        }

        System.out.print(sb);
    }
}