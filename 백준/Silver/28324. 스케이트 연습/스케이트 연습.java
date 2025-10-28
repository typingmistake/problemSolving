import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[] arr = Arrays.stream(sc.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cur = 0; // 현재 속력, 1만큼만 높일 수 있고, 낮추기는 제한 없음
        long answer = 0;
        for (int i = N-1; i >= 0; i--){
            if(arr[i] > cur){
                cur++; // 높이기
            }else{
                cur = arr[i]; // 낮추기
            }
            answer += cur;
        }

        System.out.println(answer);
    }
}