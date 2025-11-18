import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().strip();
        int N = str.length();
        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = str.substring(i);
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}