import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int idx = 0;
            while (idx < N) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println((N + 1) / 2);

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int cnt = 0;

            for(int i = 0; i < N; i++){
                // 힙에 값 추가 (maxHeap은 중간값 이하, minHeap은 중간값 초과)
                if(maxHeap.isEmpty() || arr[i] <= maxHeap.peek()){
                    maxHeap.offer(arr[i]);
                } else {
                    minHeap.offer(arr[i]);
                }

                // 균형 맞추기 (maxHeap이 최대 1개 더 많음)
                if(maxHeap.size() > minHeap.size() + 1){
                    minHeap.offer(maxHeap.poll());
                } else if(minHeap.size() > maxHeap.size()){
                    maxHeap.offer(minHeap.poll());
                }

                // 중앙값 출력
                if(i % 2 == 0){
                    cnt++;
                    System.out.print(maxHeap.peek());
                    if(cnt % 10 == 0 || i >= N - 2){
                        System.out.println();
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}