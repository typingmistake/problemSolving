import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] orders = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = i;
        }

        int result = 0;

        while(true){
            if(check(arr, target, N)){
                System.out.println(result);
                return;
            }

            arr = change(arr, orders, N);
            result += 1;

            boolean flag = true; // 중단용 플래그 -> 가망 없음

            for(int i = 0; i < N; i++){
                if (arr[i] != i) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println(-1);
                return;
            }
        }
    }

    public static int[] change(int[] arr, int[] orders, int N){
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            result[i] = arr[orders[i]];
        }

        return result;
    }

    public static boolean check(int[] arr, int[] target, int N){
        for(int i = 0; i < N; i++){
            if(arr[i]%3 != target[i]) return false;
        }
        return true;
    }
}