import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            char[] chars = br.readLine().strip().toCharArray();
            for(int i = 0; i <=25; i++){
                char[] shifted = new char[target.length];

                for(int j = 0; j < target.length; j++){
                    shifted[j] = (char)((target[j] -'a' + i)%26 + 'a');
                }

                // j는 출발점
                for(int j = 0; j < target.length-chars.length+1; j++){
                    boolean flag = true;
                    for(int k = 0; k < chars.length; k++){
                        if(shifted[j+k] != chars[k]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.println(String.valueOf(shifted));
                        return;
                    }
                }
            }
        }
    }
}