import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long M = arr[0];
            long result = -1;
            Map<Long, Integer> cntMap = new HashMap<>();

            for(int i = 1; i <= M; i++) {
                cntMap.put(arr[i], cntMap.getOrDefault(arr[i], 0) + 1);
            }

            for(long num : cntMap.keySet()) {
                if(cntMap.get(num) > M / 2) {
                    result = num;
                    break;
                }
            }

            System.out.println(result == -1 ? "SYJKGW" : result);
        }

    }
}