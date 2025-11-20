import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        Map<Integer, Integer> map = new HashMap<>();

        while(M-- > 0){
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);

            for(int i = 0; i < N; i++){
                if(line[i+1].equals("X")){
                    map.putIfAbsent(p, 0);
                    continue;
                }
                map.put(p, map.getOrDefault(p, 0) + arr[i]);
            }
        }

        int max = -1;
        int idx = -1;

        for(int i : map.keySet()){
            if(map.get(i) > max){
                max = map.get(i);
                idx = i;
            }else if(map.get(i) == max && i < idx){
                idx = i;
            }
        }

        System.out.println(idx + " " + max);
    }
}