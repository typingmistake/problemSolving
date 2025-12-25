import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[N];  // 재사용
        int[] queue = new int[N];            // 재사용

        List<Integer> result = new ArrayList<>();
        int max = 0;

        for(int i = 0; i < N; i++){
            int cnt = bfs(graph, i, visited, queue);

            if(cnt > max){
                max = cnt;
                result.clear();
                result.add(i);
            } else if(cnt == max){
                result.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int res : result){
            sb.append(res + 1).append(" ");
        }
        System.out.println(sb);
    }

    public static int bfs(List<List<Integer>> graph, int start, boolean[] visited, int[] queue){
        int front = 0, rear = 0;
        queue[rear++] = start;
        visited[start] = true;
        int cnt = 1;

        while(front < rear){
            int curr = queue[front++];

            for(int next : graph.get(curr)){
                if(visited[next]) continue;
                visited[next] = true;
                queue[rear++] = next;
                cnt++;
            }
        }

        // 방문한 노드만 초기화
        for(int i = 0; i < rear; i++){
            visited[queue[i]] = false;
        }

        return cnt;
    }
}