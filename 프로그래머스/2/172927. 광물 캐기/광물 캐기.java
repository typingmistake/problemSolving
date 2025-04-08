import java.util.*;

class Solution {
    static int[][] table = {
            { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 }
    };

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int tot = picks[0] + picks[1] + picks[2];
        int M = Math.min(tot * 5, minerals.length);

        int[] array = new int[M];
        for (int i = 0; i < M; i++) {
            if (minerals[i].equals("diamond")) {
                array[i] = 100;
            } else if (minerals[i].equals("iron")) {
                array[i] = 10;
            } else {
                array[i] = 1;
            }
        }

        int[][] sorted = sort(array);
        for (int[] arr : sorted) {
            if (picks[0] > 0) {
                answer += work(0, arr);
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += work(1, arr);
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += work(2, arr);
                picks[2]--;
            } else {
                break;
            }
        }
        return answer;
    }

    public static int[][] sort(int[] arr) {
        int size = arr.length % 5 == 0 ? arr.length / 5 : arr.length / 5 + 1;
        int[][] result = new int[size][5];
        for (int i = 0; i < size; i++) {
            int start = i * 5;
            int end = Math.min(start + 5, arr.length);
            for (int j = 0; j < end-start; j++){
                result[i][j] = arr[start+j];
            }
        }
        int[][] res = Arrays.stream(result)
                .sorted((a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum())
                .toArray(int[][]::new);
        return res;
    }

    public static int work(int pick, int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 100) {
                res += table[pick][0];
            } else if (arr[i] == 10) {
                res += table[pick][1];
            } else if (arr[i] == 1) {
                res += table[pick][2];
            }
        }
        return res;
    }
}