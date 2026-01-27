import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Character> target = new HashSet<>(){{
        add('1');
        add('6');
        add('2');
        add('7');
    }};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine().trim();
        char[] numArr = num.toCharArray();

        long k = Long.parseLong(br.readLine())-1;
        int cnt = 0;

        for(char c : numArr) {
            if(target.contains(c)) cnt++;
        }

        if(k >= (1L<<cnt)) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while(idx < numArr.length) {
            char c = numArr[idx++];

            if(!target.contains(c)) {
                sb.append(c);
                continue;
            }

            if(k < 1L<< (cnt-1)) {
                if(c == '6') sb.append('1');
                else if(c == '7') sb.append('2');
                else sb.append(c);
            } else {
                if(c == '1') sb.append('6');
                else if(c == '2') sb.append('7');
                else sb.append(c);

                k-= 1L<< (cnt-1);
            }

            cnt--;
        }

        System.out.println(sb.toString());
    }
}