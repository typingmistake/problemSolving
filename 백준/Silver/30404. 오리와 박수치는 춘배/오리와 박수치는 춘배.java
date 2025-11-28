import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int curr = arr[0];
        int ans = 0;

        for(int i = 1; i < N; i++){
            if(curr+K < arr[i]){
                ans++;
                curr = arr[i];
            }
        }

        if(curr+K < arr[0]) ans++;

        System.out.println(ans+1);
    }
}