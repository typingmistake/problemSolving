import java.util.*;

class Solution {

    public class Node {
        int val; // 0: 양, 1: 늑대
        ArrayList<Node> children = new ArrayList<>();
    }

    public int solution(int[] info, int[][] edges) {
        int n = info.length; // 전체 노드 개수
        Node[] nodes = new Node[n];

        // 노드 생성
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].val = info[i];
        }

        // 간선 연결
        for (int[] edge : edges) {
            Node parent = nodes[edge[0]];
            Node child = nodes[edge[1]];
            parent.children.add(child);
        }

        // 깊이 우선 탐색
        return dfs(nodes[0], info);
    }

    public int dfs(Node head, int[] info) {
        int ans = 0;

        // 노드, 양 수, 늑대 수, 방문 가능한 노드 리스트
        Deque<Object[]> stack = new ArrayDeque<>();

        List<Node> initialPath = new ArrayList<>();
        // 루트 노드의 자식들을 방문 가능한 노드에 추가
        for (Node child : head.children) {
            initialPath.add(child);
        }

        stack.push(new Object[] { new int[] { 1, 0 }, initialPath });

        while (!stack.isEmpty()) {
            Object[] curr = stack.removeLast();
            int[] count = (int[]) curr[0];
            List<Node> availableNodes = (List<Node>) curr[1];

            // 양의 최대 수 갱신
            ans = Math.max(ans, count[0]);

            // 다음 방문 가능한 모든 노드에 대해
            for (int i = 0; i < availableNodes.size(); i++) {
                Node nextNode = availableNodes.get(i);

                int[] nextCount = new int[] { count[0], count[1] }; // 양, 늑대 수
                nextCount[nextNode.val]++;

                // 양이 늑대보다 많아야 방문 가능
                if (nextCount[0] > nextCount[1]) {
                    // 다음 방문 가능한 노드 목록 갱신
                    List<Node> newAvailable = new ArrayList<>(availableNodes);
                    newAvailable.remove(i); // 현재 방문한 노드 제거

                    // 방문한 노드의 자식들 추가
                    for (Node child : nextNode.children) {
                        newAvailable.add(child);
                    }

                    stack.push(new Object[] { nextCount, newAvailable });
                }
            }
        }

        return ans;
    }
}