import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] target = br.readLine().split(" "); // 부등호

        for(int i = 0; i <= 9; i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(i);

            boolean[] visited = new boolean[10]; // 0~9
            visited[i] = true;

            solve(curr, N, target, visited);
        }

        System.out.println(String.format("%0"+(N+1)+"d", max));
        System.out.println(String.format("%0"+(N+1)+"d", min));
    }
    public static void solve(List<Integer> curr, int N, String[] target, boolean[] visited){
        if(curr.size() == N+1){
            update(curr);
            return;
        }

        int idx = curr.size()-1;
        int last = curr.get(idx);

        // 부등호 <
        if(target[idx].equals("<")){
            for(int i = last+1; i <= 9; i++){
                if(visited[i]) continue;

                visited[i] = true;
                curr.add(i);

                solve(curr, N, target, visited);

                visited[i] = false;
                curr.remove(curr.size()-1);
            }

            return;
        }

        // 부등호 >
        for(int i = 0; i < last; i++){
            if(visited[i]) continue;

            visited[i] = true;
            curr.add(i);

            solve(curr, N, target, visited);

            visited[i] = false;
            curr.remove(curr.size()-1);
        }

    }
    public static void update(List<Integer> curr){
        long result = 0;
        for(int i = 0; i < curr.size(); i++){
            result *= 10;
            result += curr.get(i);
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
    }
}