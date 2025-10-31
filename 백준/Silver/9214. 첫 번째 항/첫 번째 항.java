import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;

        while(true) {
            String num = br.readLine().strip();
            if(num.equals("0")) break;

            System.out.println("Test " + ++idx + ": " + getFirst(num));
        }
    }

    public static String getFirst(String curr) {
        int len = curr.length();
        String prev = "";
        StringBuilder sb;

        while(len%2==0 && !curr.equals(prev)){
            prev = curr;
            sb = new StringBuilder();

            for(int i = 0; i < len; i+=2){
                int cnt = Integer.parseInt(curr.charAt(i) + "");
                while(cnt-- > 0){
                    sb.append(curr.charAt(i + 1));
                }
            }

            curr = sb.toString();
            len = curr.length();
        }

        return curr;
    }
}