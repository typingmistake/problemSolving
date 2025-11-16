import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        long[][] edges = new long[M][3];

        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            edges[i][0] = Long.parseLong(line[0])-1; // u
            edges[i][1] = Long.parseLong(line[1])-1; // v
            edges[i][2] = Long.parseLong(line[2]); // w
        }

        Arrays.sort(edges, (a, b) -> Long.compare(a[2], b[2])); // 간선 가중치 오름차순 정렬

        long sum = 0;
        for(int i = 0; i < M; i++){
            sum += edges[i][2];
        }

        int[] parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;

        long cost = 0; // 현재까지 유지비 합
        int result = 0; // 현재까지 선택된 간선 수
        int idx = 0; // 간선 인덱스

        while(result < N-1){
            long u = edges[idx][0];
            long v = edges[idx][1];
            long w = edges[idx][2];

            int pu = find(parent, (int)u);
            int pv = find(parent, (int)v);

            // 연결되지 않은 경우 연결
            if(pu != pv){
                parent[pu] = pv; // union
                cost += w;
                result++;
            }

            idx++;

            if(idx == M) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sum-cost);
    }
    public static int find(int[] parent, int u){
        if(parent[u] != u) parent[u] = find(parent, parent[u]);
        return parent[u];
    }
}