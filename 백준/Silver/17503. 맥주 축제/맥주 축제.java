import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long M = Long.parseLong(input[1]);
        int K = Integer.parseInt(input[2]);
        long[][] arr = new long[K][2];

        for (int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][0] = Long.parseLong(line[0]);
            arr[i][1] = Long.parseLong(line[1]);
        }

        Arrays.sort(arr, (a, b) -> Long.compare(b[0], a[0]));

        long start = 0;
        long end = -1;

        for(int i = 0; i < arr.length; i++){
            end = Math.max(end, arr[i][1]);
        }

        if(!isPossible(arr, end, M, N)){
            System.out.println(-1);
            return;
        }

        while(start < end){
            long piv = (start + end) / 2;

            if(isPossible(arr, piv, M, N)){
                end = piv;
            } else {
                start = piv + 1;
            }
        }

        System.out.println(start);
    }

    public static boolean isPossible(long[][] arr, long level, long M, int N){
        long curr = 0;
        int cnt = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i][1] <= level){
                curr += arr[i][0];
                cnt++;
            }

            if(curr >= M && cnt == N){
                break;
            }
        }

        return curr >= M && cnt == N;
    }
}