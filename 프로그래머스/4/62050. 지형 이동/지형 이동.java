import java.util.*;

class Solution {
    class Block {
        int x, y;
        Block parent;

        Block(int x, int y, int h) {
            this.parent = this;
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;

        Block[][] blocks = new Block[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = new Block(i, j, land[i][j]);
            }
        }

        // 유니온 파인드로 블록 연결
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && Math.abs(land[i][j] - land[i - 1][j]) <= height) {
                    find(blocks[i][j]).parent = find(blocks[i - 1][j]);
                }
                if (j > 0 && Math.abs(land[i][j] - land[i][j - 1]) <= height) {
                    find(blocks[i][j]).parent = find(blocks[i][j - 1]);
                }
            }
        }

        // 서로 다른 유니온 간 다리 비용 수집
        Map<String, int[]> costMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Block curr = find(blocks[i][j]);
                int[][] adjs = { { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 } };

                for (int[] adj : adjs) {
                    int x = adj[0], y = adj[1];
                    if (x < 0 || x >= n || y < 0 || y >= n)
                        continue;

                    Block next = find(blocks[x][y]);
                    if (curr == next)
                        continue;

                    int cost = Math.abs(land[i][j] - land[x][y]);
                    String key = getKey(curr, next, n);

                    if (!costMap.containsKey(key) || costMap.get(key)[2] > cost) {
                        costMap.put(key, new int[] { curr.x * n + curr.y, next.x * n + next.y, cost });
                    }
                }
            }
        }

        // 유니온 그룹 수 세기
        Set<Block> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roots.add(find(blocks[i][j]));
            }
        }
        int cnt = roots.size();

        // 최소 비용으로 연결 (MST)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.addAll(costMap.values());

        while (!pq.isEmpty() && cnt > 1) {
            int[] info = pq.poll();
            int id1 = info[0], id2 = info[1], cost = info[2];
            Block a = find(blocks[id1 / n][id1 % n]);
            Block b = find(blocks[id2 / n][id2 % n]);

            if (a != b) {
                a.parent = b;
                answer += cost;
                cnt--;
            }
        }

        return answer;
    }

    public Block find(Block a) {
        if (a.parent != a) {
            a.parent = find(a.parent);
        }
        return a.parent;
    }

    private String getKey(Block a, Block b, int n) {
        Block r1 = find(a), r2 = find(b);
        int id1 = r1.x * n + r1.y;
        int id2 = r2.x * n + r2.y;
        if (id1 > id2) {
            int temp = id1;
            id1 = id2;
            id2 = temp;
        }
        return id1 + "," + id2;
    }
}
