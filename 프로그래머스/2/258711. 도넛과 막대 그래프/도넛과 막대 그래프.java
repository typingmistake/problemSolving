import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> start;
    static Map<Integer, List<Integer>> end;
    static boolean[] visited;
    static int nodeNum;
    static int gen;

    public int[] solution(int[][] edges) {
        nodeNum = -1;
        int[] answer = new int[3];
        Arrays.fill(answer, 0);
        visited = new boolean[1_000_001];

        start = new HashMap<>();
        end = new HashMap<>();
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];

            nodeNum = Math.max(nodeNum, Math.max(startNode, endNode));

            start.putIfAbsent(startNode, new ArrayList<>());
            end.putIfAbsent(endNode, new ArrayList<>());
            start.get(startNode).add(endNode);
            end.get(endNode).add(startNode);
        }

        for (int i = 1; i <= nodeNum; i++) {
            // i에서 끝나는 간선이 없고, i에서 시작하는 간선이 2개 이상이면
            if (!end.containsKey(i) && start.getOrDefault(i, new ArrayList<>()).size() >= 2) {
                gen = i;
                break;
            }
        }

        for (int node : start.get(gen)) {
            // 각 check() 호출 전에 visited 배열을 초기화
            Arrays.fill(visited, false);
            answer[check(node)]++;
        }

        return new int[] { gen, answer[0], answer[1], answer[2] };
    }

    public static int check(int first) {
        // 시작 노드 방문 표시
        visited[first] = true;
        
        if (!start.containsKey(first) || start.get(first).isEmpty()) {
            // 막대 모양: 첫 번째 노드에서 시작하는 간선이 없음
            return 1;
        }

        // 노드 수와 간선 수 계산
        int nodeCount = 1; // 시작 노드 포함
        int edgeCount = 0;
        
        // DFS로 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.add(first);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : start.getOrDefault(current, new ArrayList<>())) {
                edgeCount++; // 간선 수 증가
                
                if (!visited[next]) {
                    visited[next] = true;
                    nodeCount++; // 노드 수 증가
                    queue.add(next);
                }
            }
        }
        
        // 그래프 유형 판별
        if (nodeCount == edgeCount) {
            return 0; // 도넛 모양
        } else if (nodeCount == edgeCount + 1) {
            return 1; // 막대 모양
        } else {
            return 2; // 8자 모양
        }
    }
}