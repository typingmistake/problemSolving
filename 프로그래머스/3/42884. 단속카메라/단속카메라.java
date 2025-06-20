
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> a[0] - b[0]); // 시작 지점 기준 정렬
        int idx = 0;
        int curr = Integer.MIN_VALUE;
        while (idx < routes.length) {
            if (routes[idx][0] > curr) {
                answer++; // 이전 종료 지점에 카메라 설치
                curr = routes[idx][1];
            }

            curr = Math.min(curr, routes[idx][1]); // 종료 지점 갱신
            idx++;
        }

        return answer;
    }
}