import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        // 초기화: 로봇 위치를 첫 번째 포인트로 설정
        int robots = routes.length;
        int pos[] = new int[robots];
        for (int i = 0; i < robots; i++) {
            int pointNum = routes[i][0] - 1;
            pos[i] = points[pointNum][0] * 1000 + points[pointNum][1];
        }

        int[] targetIdx = new int[robots];
        Arrays.fill(targetIdx, 1); // 다음 목표는 두 번째 포인트
        boolean[] active = new boolean[robots];
        Arrays.fill(active, true);

        int answer = 0;

        while (hasActiveRobot(active)) {

            // 충돌 확인
            Map<Integer, Integer> posCount = new HashMap<>();
            for (int j = 0; j < robots; j++) {
                if (!active[j])
                    continue;

                posCount.put(pos[j], posCount.getOrDefault(pos[j], 0) + 1);
            }

            for (int count : posCount.values()) {
                if (count > 1) {
                    answer++;
                }
            }

            // 모든 로봇 이동
            for (int i = 0; i < robots; i++) {
                if (!active[i])
                    continue;

                int pointNum = routes[i][targetIdx[i]] - 1;
                int target = points[pointNum][0] * 1000 + points[pointNum][1];

                // 현재 목표 도달
                if (pos[i] == target) {
                    targetIdx[i]++;

                    // 마지막 포인트 확인
                    if (targetIdx[i] == routes[i].length) {
                        active[i] = false;
                        continue;
                    }

                    // 다음 목표 갱신
                    pointNum = routes[i][targetIdx[i]] - 1;
                    target = points[pointNum][0] * 1000 + points[pointNum][1];
                }

                // 이동 (r 좌표 우선)
                // 이동 (r 좌표 우선)
                if (pos[i] / 1000 < target / 1000) {
                    pos[i] += 1000;
                } else if (pos[i] / 1000 > target / 1000) {
                    pos[i] -= 1000;
                } else if (pos[i] % 1000 < target % 1000) {
                    pos[i]++;
                } else {
                    pos[i]--;
                }
            }
        }

        return answer;
    }

    private boolean hasActiveRobot(boolean[] active) {
        for (boolean a : active) {
            if (a)
                return true;
        }
        return false;
    }
}