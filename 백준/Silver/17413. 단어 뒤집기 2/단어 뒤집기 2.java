import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str = sc.readLine().strip();
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();

        for (char c : str.toCharArray()) {

            if(c == '<'){
                // 쌓아온 문자열 처리
                String[] strArr = temp.toString().split(" ");
                String[] reversed = new String[strArr.length];

                for(int j = 0; j < strArr.length; j++){
                    StringBuilder sb = new StringBuilder(strArr[j]);
                    reversed[j] = sb.reverse().toString();
                }

                result.append(String.join(" ", reversed));

                // < 태그 처리
                temp = new StringBuilder();
                stack.add(c);
                result.append(c);
                continue;
            }

            if(c == '>') {
                result.append(c);
                stack.pop();

                continue;
            }

            // 태그 밖 문자는 임시저장
            if(stack.isEmpty()){
                temp.append(c);
                continue;
            }

            result.append(c); // 태그 안 문자는 바로 저장
        }

        // 남은 문자 처리
        String[] strArr = temp.toString().split(" ");
        String[] reversed = new String[strArr.length];

        for(int j = 0; j < strArr.length; j++){
            StringBuilder sb = new StringBuilder(strArr[j]);
            reversed[j] = sb.reverse().toString();
        }

        result.append(String.join(" ", reversed));

        System.out.println(result.toString());
    }
}