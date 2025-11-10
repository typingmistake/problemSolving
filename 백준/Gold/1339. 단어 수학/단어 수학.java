import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        long[] weights = new long[26];

        for(int i = 0; i < N; i++){
            nums[i] = br.readLine().strip();
            int len = nums[i].length();

            for(int j = 0; j < len; j++){
                char c = nums[i].charAt(j);
                weights[c - 'A'] += (long)Math.pow(10, len - 1 - j);
            }
        }

        List<long[]> list = new ArrayList<>();
        for(long i = 0; i < 26; i++){
            if(weights[(int)i] > 0){
                list.add(new long[]{i, weights[(int)i]}); // 문자 인덱스, 가중치
            }
        }

        list.sort((a, b) -> Long.compare(b[1], a[1]));

        Map<Character, Integer> map = new HashMap<>();
        int value = 9;
        for(long[] num : list){
            char c = (char)('A' + num[0]);
            map.put(c, value--);
        }

        long answer = 0;
        for(String num : nums){
            long sum = 0;
            for(char c : num.toCharArray()){
                sum = sum * 10 + map.get(c);
            }
            answer += sum;
        }

        System.out.println(answer);
    }
}