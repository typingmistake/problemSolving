import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        String numStr = br.readLine().strip();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = numStr.charAt(i) - '0';
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int curr = nums[i];
            int size = i-K+1; // 최소한 이만큼은 남겨둬야 함.

            while(!stack.isEmpty() && stack.size() >= size && stack.peek() < curr){
                stack.pop();
            }

            stack.push(curr);
        }

        // K개 제거하고 선택
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < N - K; i++){
            ans.append(stack.get(i));
        }

        System.out.println(ans);
    }
}