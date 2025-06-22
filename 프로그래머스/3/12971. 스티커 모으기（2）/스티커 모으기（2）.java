
import java.util.Arrays;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if (n == 1)
            return sticker[0];

        // 첫번째와 마지막 둘 다 포함할 수 없으므로, 두 가지 경우로 나누어 계산
        int[] arr1 = Arrays.stream(sticker).limit(n - 1).toArray(); // 첫 번째 스티커를 포함하는 경우
        int[] arr2 = Arrays.stream(sticker).skip(1).toArray(); // 마지막 스티커를 포함하는 경우

        return Math.max(solve(arr1, n - 1), solve(arr2, n - 1));
    }

    public int solve(int[] arr, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);

        arr[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            // 이번 스티커를 붙일지 말지 결정
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
        }

        return arr[n - 1];
    }
}