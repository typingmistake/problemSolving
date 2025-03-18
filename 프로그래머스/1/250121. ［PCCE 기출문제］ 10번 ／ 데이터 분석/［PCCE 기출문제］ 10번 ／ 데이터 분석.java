import java.util.*;

class Solution {
    static Map<String, Integer> map = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data).filter((arr) -> arr[map.get(ext)] < val_ext).sorted((a, b) -> {
            return Integer.compare(a[map.get(sort_by)], b[map.get(sort_by)]);
        }).toArray(int[][]::new);
    }
}