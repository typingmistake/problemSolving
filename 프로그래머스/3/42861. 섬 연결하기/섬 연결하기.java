import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0; // 현재 설치한 간선의 수
        int[] parent = new int[n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기 부모는 자기자신
        }

        pq.addAll(Arrays.asList(costs));

        while (cnt < n - 1) {
            int[] curr = pq.remove();
            int a = find(parent, curr[0]), b = find(parent, curr[1]);

            if (a != b) {
                parent[b] = a; // 부모 업데이트
                answer += curr[2];
                cnt++;
            }
        }

        return answer;
    }

    public int find(int[] parent, int a) {
        if (parent[a] != a) {
            parent[a] = find(parent, parent[a]);
            return parent[a];
        }
        return a;
    }
}