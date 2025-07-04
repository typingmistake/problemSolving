import java.util.*;

class Solution {
    class Node {
        int res;
        Node parent;
        List<Node> children;

        Node() {
            this.res = 0;
            this.children = new ArrayList<>();
        }

        void setParent(Node parent) {
            this.parent = parent;
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Node> map = new HashMap<>();
        Node center = new Node(); // 루트 노드
        map.put("-", center);

        for (String enroll1 : enroll) {
            Node node = new Node();
            map.put(enroll1, node);
        }

        for (int i = 0; i < enroll.length; i++) {
            Node child = map.get(enroll[i]);
            Node parent = map.get(referral[i]);

            child.setParent(parent);
            parent.children.add(child);
        }

        for (int i = 0; i < seller.length; i++) {
            Node node = map.get(seller[i]);
            int p = amount[i] * 100;
            node.res += p;
            p = (int) Math.floor(p * 0.1); // 10% 수수료

            while (p > 0 && node.parent != null) {
                node.res -= p; // 수수료 지급
                node = node.parent;
                node.res += p; // 수수료 수령
                p = (int) Math.floor(p * 0.1);
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            Node node = map.get(enroll[i]);
            answer[i] = node.res;
        }

        return answer;
    }
}