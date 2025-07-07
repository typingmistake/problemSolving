import java.util.*;

class Solution {
    class Node {
        int num; // 권투선수 번호
        List<Node> win;
        List<Node> lose;

        Node(int num) {
            this.num = num;
            win = new ArrayList<>();
            lose = new ArrayList<>();
        }

        void addWin(Node node) {
            win.add(node);
        }

        void addLose(Node node) {
            lose.add(node);
        }

    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Node player = new Node(i);
            map.put(i, player);
        }

        for (int[] result : results) {
            Node winner = map.get(result[0]);
            Node loseer = map.get(result[1]);

            winner.addWin(loseer);
            loseer.addLose(winner);
        }

        for (Node node : map.values()) {
            if (check(node, n)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(Node node, int n) {
        Set<Node> res = new HashSet<>();
        res.add(node);
        Queue<Node> up = new ArrayDeque<>();
        up.offer(node);
        Queue<Node> down = new ArrayDeque<>();
        down.offer(node);

        // 윗방향 bfs
        while (!up.isEmpty()) {
            Node curr = up.remove();
            for (Node next : curr.win) {
                if (res.contains(next))
                    continue;

                res.add(next);
                up.add(next);
            }

        }

        // 아랫방향 bfs
        while (!down.isEmpty()) {
            Node curr = down.remove();
            for (Node next : curr.lose) {
                if (res.contains(next))
                    continue;

                res.add(next);
                down.add(next);
            }
        }

        return res.size() == n;
    }
}