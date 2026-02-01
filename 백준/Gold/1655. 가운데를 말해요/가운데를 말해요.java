import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if(maxHeap.size() > minHeap.size()+1){
                minHeap.offer(maxHeap.remove());
            } else if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.remove());
            }

            System.out.println(maxHeap.peek());
        }
    }
}