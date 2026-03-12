import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX = Integer.MAX_VALUE/2;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        parent = new int[N];
        int total = 0; // 총 랜선 길이
        int cost = 0; // MST 비용
        int cnt = 0; // 연결된 랜선 수

        for(int i = 0; i < N; i++){
            parent[i] = i;
        }


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int num = charToInt(line.charAt(j));
                if(num == -1) continue;
                pq.add(new int[]{num, i, j});
                total += num;
            }
        }

        while(!pq.isEmpty() && cnt < N-1){
            int[] curr = pq.remove();
            int pa = find(curr[1]);
            int pb = find(curr[2]);

            if(pa == pb) continue;
            parent[pb] = pa; // union
            cost += curr[0];
            cnt++;
        }

        System.out.println(cnt == N-1 ? total - cost : -1);
    }

    public static int charToInt(char c) {
        if('a' <= c && c <= 'z') {
            return c - 'a' + 1; // a~z는 1~26
        } else if('A' <= c && c <= 'Z') {
            return c - 'A' + 27; // A~Z는 27~52
        }
        return -1; // '0'인 경우
    }

    public static int find(int n){
        if(parent[n] != n) parent[n] = find(parent[n]); // 경로 압축
        return parent[n];
    }
}