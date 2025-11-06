import java.util.Stack;

public class Solution {
    static class Node {
        Node prev;
        Node next;
        boolean isDeleted = false; // 삭제 여부
    }
    static class DoubleLinkedList {
        Node head;
        Node tail;
        int size = 0;

        DoubleLinkedList(int n) {
            for(int i = 0; i < n; i++){
                addNode();
            }
            size = n;
        }

        void addNode() {
            if(head == null || tail == null){
                head = tail = new Node();
                return;
            }
            Node newNode = new Node();
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        String getList(){
            StringBuilder sb = new StringBuilder();
            Node curr = head;
            while(curr != null){
                if(curr.isDeleted) sb.append("X");
                else sb.append("O");
                curr = curr.next;
            }
            return sb.toString();
        }
    }
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> deleted = new Stack<>();
        DoubleLinkedList dll = new DoubleLinkedList(n);
        Node selected = dll.head;

        // k번째 노드로 이동
        for(int i = 0; i < k; i++){
            selected = selected.next;
        }

        for(String command : cmd){
            String[] parts = command.split(" ");
            String opt = parts[0];

            if(opt.equals("U")){
                int cnt = 0;
                int move = Integer.parseInt(parts[1]);
                Node curr = selected;
                while(cnt < move){
                    curr = curr.prev;
                    cnt++;
                }
                selected = curr;
                continue;
            }

            if(opt.equals("D")){
                int cnt = 0;
                int move = Integer.parseInt(parts[1]);
                Node curr = selected;
                while(cnt < move){
                    curr = curr.next;
                    cnt++;
                }
                selected = curr;
                continue;
            }

            if(opt.equals("C")){
                selected.isDeleted = true;
                deleted.push(selected); // 삭제된 노드 정보 추가
                Node prev = selected.prev;
                Node next = selected.next;

                if(prev == null){
                    dll.head = next;
                    next.prev = null;
                    selected = next;
                }else if(next == null){
                    dll.tail = prev;
                    prev.next = null;
                    selected = prev;
                }else{
                    prev.next = next;
                    next.prev = prev;
                    selected = next;
                }
                continue;
            }

            if(opt.equals("Z")){
                Node node = deleted.pop();
                node.isDeleted = false;

                if(node.prev == null){
                    dll.head = node;
                    node.next.prev = node;
                }else if(node.next == null){
                    dll.tail = node;
                    node.prev.next = node;
                } else{
                    node.prev.next = node;
                    node.next.prev = node;
                }
            }
        }

        // 삭제된 노드들 복구
        while(!deleted.isEmpty()){
            Node node = deleted.pop();

            if(node.prev == null){
                dll.head = node;
                node.next.prev = node;
            }else if(node.next == null){
                dll.tail = node;
                node.prev.next = node;
            } else{
                node.prev.next = node;
                node.next.prev = node;
            }
        }

        return dll.getList();
    }
}
