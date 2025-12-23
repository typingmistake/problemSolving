import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int sum = 0;

        for(int i = 0; i < N; i++){
            if(sum + 1 < arr[i]){
                System.out.println(sum + 1);
                return;
            }
            sum += arr[i];
        }

        System.out.println(sum + 1);

    }
}