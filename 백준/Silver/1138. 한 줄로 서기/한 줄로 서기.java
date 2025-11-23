import java.io.*;
import java.util.Arrays;

public class Main {
    public static class Node {
        int num;
        Node next;

        public Node(int num) {
            this.num = num;
            this.next = null;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Node root = new Node(-1); // 루트 노드

        for(int i = N-1; i >= 0; i--){
            int target = arr[i];
            int num = i+1;
            Node newNode = new Node(num); // 추가할 노드
            Node currNode = root;
            int cnt = 0;

            // 이동
            while(cnt < target){
                currNode = currNode.next;
                if(currNode.num > num){
                    cnt++;
                }
            }

            // 노드 추가
            newNode.next = currNode.next;
            currNode.next = newNode;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        Node currNode = root.next;
        sb.append(currNode.num);

        while(currNode.next != null){
            currNode = currNode.next;
            sb.append(" ").append(currNode.num);
        }

        System.out.println(sb.toString());
    }

}