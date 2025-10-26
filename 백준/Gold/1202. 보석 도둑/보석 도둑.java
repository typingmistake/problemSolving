import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = sc.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        long answer = 0;

        int[][] items = new int[N][2];
        for (int i = 0; i < N; i++) {
            inputs = sc.readLine().split(" ");
            int w = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);
            items[i] = new int[]{w, v};
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(sc.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Arrays.sort(items, (a, b) -> a[0] - b[0]); // 무게 기준 오름차순 정렬
        Arrays.sort(bags); // 오름차순 정렬
        int itemIndex = 0;

        for (int i = 0; i < K; i++){
            int currCapacity = bags[i];
            // 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 추가
            while(itemIndex < N && items[itemIndex][0] <= currCapacity){
                pq.add(items[itemIndex++][1]);
            }

            // 가장 가치가 높은 보석을 가방에 담기
            if(!pq.isEmpty()){
                answer += pq.remove();
            }

        }

        System.out.println(answer);
    }
}
