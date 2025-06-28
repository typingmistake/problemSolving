import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int M = Arrays.stream(stones).max().orElse(0);
        return binarySearch(stones, M, k);
    }

    public static int binarySearch(int[] stones, int M, int k) {
        int left = 1, right = M;
        while (left <= right) {
            if (left == right)
                return left;

            int pivot = (left + right + 1) / 2;
            if (check(stones, k, pivot)) {
                left = pivot ;
            } else {
                right = pivot - 1;
            }
        }

        return -1;
    }

    public static boolean check(int[] stones, int k, int mid) {
        int cnt = 0; // 연속으로 무너지는 디딤돌 개수
        for (int stone : stones) {
            if (stone < mid) {
                cnt++;
                if (cnt >= k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}