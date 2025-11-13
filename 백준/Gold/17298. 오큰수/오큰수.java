import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().strip();
        int N = Integer.parseInt(line);
        String[] parts = br.readLine().strip().split(" ");

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        for(int i = N-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N-1; i++){
            sb.append(ans[i]).append(" ");
        }
        sb.append(ans[N-1]);

        System.out.println(sb);
    }
}