import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxLen = -1;

        Map<String, String> map = new HashMap<>(); // key: 접두어, value: 단어
        String first = "", second = "";

        String[] words = new String[N];

        for(int i = 0; i < N; i++){
            words[i] = br.readLine().trim();
        }

        for(int i = N-1; i >= 0; i--){
            String prefix = "";
            String word = words[i];
            int M = word.length();

            if(maxLen == 0){
                second = map.getOrDefault(word, "");
                first = word;
            }

            // prefix 증가 -> 결과 업데이트 -> 추가
            for(int j = 0; j < M; j++) {
                prefix += word.charAt(j);

                // 업데이트
                if (map.containsKey(prefix) && prefix.length() >= maxLen) {
                    maxLen = prefix.length();
                    second = map.get(prefix);
                    first = word;
                }

                map.put(prefix, word);
            }
        }

        System.out.println(first);
        System.out.println(second);
    }
}