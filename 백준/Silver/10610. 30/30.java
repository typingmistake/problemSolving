import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder num = new StringBuilder(br.readLine());
        int N = num.length();
        char[] arr = new char[N];
        int zeroPos = -1;
        int sum = 0;

        for(int i = 0; i < N; i++){
            arr[i] = num.charAt(i);
            sum += num.charAt(i) - '0';
            if(num.charAt(i) == '0') zeroPos = i;
        }

        // 검증
        if(sum % 3 != 0 || zeroPos == -1){
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);

        for(int i = N-1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
