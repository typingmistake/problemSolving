import java.util.*;

class Solution {
    static class Node {
        int val;
        int x, y;
        Node left, right;

        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a.y != b.y)
                return b.y - a.y;
            return a.x - b.x;
        });

        Node rootNode = nodes[0];
        for (int i = 1; i < n; i++) {
            insertNode(rootNode, nodes[i]);
        }

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        preorder(rootNode, preorderList);
        postorder(rootNode, postorderList);

        int[][] answer = new int[2][n];
        answer[0] = preorderList.stream().mapToInt(i -> i).toArray();
        answer[1] = postorderList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    private void insertNode(Node parent, Node node) {
        if (node.x < parent.x) {
            if (parent.left == null) {
                parent.left = node;
            } else {
                insertNode(parent.left, node);
            }
        } else {
            if (parent.right == null) {
                parent.right = node;
            } else {
                insertNode(parent.right, node);
            }
        }
    }

    // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
    private void preorder(Node node, List<Integer> result) {
        if (node == null)
            return;

        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
    private void postorder(Node node, List<Integer> result) {
        if (node == null)
            return;

        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }
}