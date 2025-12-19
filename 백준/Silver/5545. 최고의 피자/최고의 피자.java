import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(br.readLine());

        int cal = C;
        int price = A;
        int[] arr = new int[N*2];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i = 2*N-1; i >= 0; i--){
            double curr = (double)cal/price;
            double next = (double)(cal + arr[i])/(price + B);

            if(next > curr){
                cal += arr[i];
                price += B;
                continue;
            }

            break;
        }

        System.out.println(cal/price);
    }
}