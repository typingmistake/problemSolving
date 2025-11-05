import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);
        int cnt = 1;
        int answer = 1;
        for(int i = 1; i < N; i++){
            if(arr[i] == arr[i-1]){
                cnt += 1;
                answer = Math.max(answer, cnt);
                continue;
            }
            cnt = 1; // 리셋
        }

        System.out.println(answer);
    }
}