import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().strip();
        int N = Integer.parseInt(line);

        Map<Long, Integer> map = new HashMap<>(); // 숫자, 빈도수

        for(int i = 0; i < N; i++){
            long num = Long.parseLong(br.readLine().strip());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        long ans = 0;
        for(long num : map.keySet()){
            if(max < map.get(num)){
                max = map.get(num);
                ans = num;
            } else if(max == map.get(num)){
                ans = Math.min(ans, num);
            }
        }

        System.out.println(ans);
    }
}