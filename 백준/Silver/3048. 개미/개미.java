import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N1 = Integer.parseInt(input[0]);
        int N2 = Integer.parseInt(input[1]);
        char[] arr1 = br.readLine().strip().toCharArray();
        char[] arr2 = br.readLine().strip().toCharArray();

        char[][] arr = new char[N1+N2][2];

        for(int i = N1-1; i >= 0; i--){
            arr[N1-1 - i][0] = arr1[i]; // 문자
            arr[N1-1 - i][1] = '1'; // 방향
        }
        for(int i = 0; i < N2; i++){
            arr[N1 + i][0] = arr2[i]; // 문자
            arr[N1 + i][1] = '2'; // 방향
        }

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            for(int i = 0; i < N1+N2-1; i++){
                if(arr[i][1] == '1' &&  arr[i+1][1] == '2'){
                    char[] temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N1+N2; i++){
            sb.append(arr[i][0]);
        }

        System.out.println(sb.toString());
    }
}