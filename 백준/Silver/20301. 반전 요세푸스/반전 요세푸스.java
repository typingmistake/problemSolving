import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }
}

class CircularLinkedList {
    Node current;
    int size;

    CircularLinkedList(int n) {
        Node head = new Node(1);
        Node curr = head;
        size = n;

        for(int i = 2; i <= n; i++) {
            Node newNode = new Node(i);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        curr.next = head;
        head.prev = curr;

        current = head;
    }

    void moveForward(int k) {
        for(int i = 0; i < k; i++) {
            current = current.next;
        }
    }

    void moveBackward(int k) {
        for(int i = 0; i < k; i++) {
            current = current.prev;
        }
    }

    // 현재 노드 제거
    int remove() {
        int value = current.value;
        Node prev = current.prev;
        Node next = current.next;

        prev.next = next;
        next.prev = prev;

        current = next;  // 다음 노드로 이동
        size--;

        return value;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int M = Integer.parseInt(line[2]);

        CircularLinkedList list = new CircularLinkedList(N);
        int cnt = 0;

        while(!list.isEmpty()) {
            boolean forward = (cnt / M) % 2 == 0;

            if(forward) {
                list.moveForward(K - 1);
            } else {
                list.moveBackward(K);
            }

            System.out.println(list.remove());
            cnt++;
        }
    }
}