import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cnt = new int[N+2];

        for(int i = N-1; i >= 0; i--){
            cnt[arr[i]] = cnt[arr[i]+1] + 1;
        }

        int max = Arrays.stream(cnt).max().getAsInt();

        System.out.println(N-max);
    }
}