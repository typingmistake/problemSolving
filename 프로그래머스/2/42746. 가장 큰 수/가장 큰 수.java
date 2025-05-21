import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String[] sorted = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .sorted((a, b) -> Integer.parseInt(b + a) - Integer.parseInt(a + b))
                .toArray(String[]::new);

        return String.join("", sorted).replaceFirst("^0+", "0");
    }
}