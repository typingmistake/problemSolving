import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().strip();
        String target = br.readLine().strip();
        int idx = target.length() - 1;

        while(target.length() > str.length()){
            if(target.charAt(idx) == 'A'){
                target = target.substring(0, idx);
            } else{
                target = target.substring(0, idx);
                StringBuilder sb = new StringBuilder(target);
                target = sb.reverse().toString();
            }
            idx--;
        }

        if(str.equals(target)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}