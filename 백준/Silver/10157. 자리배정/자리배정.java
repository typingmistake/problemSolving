import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine());

        int[] result = solve(C, R, K);

        if(K > C * R){
            System.out.println(0);
            return;
        }

        System.out.println((result[0]+1) + " " + (result[1]+1));
    }
    public static int[] solve(int c, int r, int k) {
        if(r==1) return new int[] {k-1, 0};
        if(c==1) return new int[] {0, k-1};

        // 테두리에 있는 경우
        if(k <= (2*c + 2*r - 4)){
            if(k <= r) return new int[] {0, k-1};
            k -= r;
            if(k < c) return new int[] {k, r-1};
            k -= c-1;
            if(k < r) return new int[] {c-1, r-1-k};
            k -= r-1;
            return new int[] {c-1-k, 0};
        }

        // 내부에 있는 경우
        int[] temp = solve(c - 2, r - 2, k-(2*c + 2*r - 4));
        return new int[] {temp[0] + 1, temp[1] + 1};
    }
}