import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int result = solve(arr, 0, M, 0);
        System.out.println(M==0 ? result -1 : result);
    }
    public static int solve(int[] arr, int idx, int target, int sum){
        if(idx == arr.length){
            return sum == target ? 1 : 0;
        }

        return solve(arr, idx+1, target, sum + arr[idx])
                + solve(arr, idx+1, target, sum);
    }

}