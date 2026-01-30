import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[N];

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = N - 1; i >= 0; i--) {
            int target = cnt.get(arr[i]);
            int res = -1;
            int curr;

            while(!stack.isEmpty()){
                curr = stack.peek();
                if(target < cnt.get(curr)){
                    res = curr;
                    break;
                } else {
                    stack.pop();
                }
            }

            stack.push(arr[i]);
            result[i] = res;
        }

        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }
}