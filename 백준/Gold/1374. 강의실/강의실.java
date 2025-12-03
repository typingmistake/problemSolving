import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        while (N-- > 0) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[1]);
            int end = Integer.parseInt(line[2]);

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> a-b);

        int curr = 0;
        int max = 0;

        for (int key : keys) {
            curr += map.get(key);
            max = Math.max(max, curr);
        }

        System.out.println(max);
    }
}