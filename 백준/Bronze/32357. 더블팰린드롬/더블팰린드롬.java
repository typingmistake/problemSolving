import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(N-- > 0){
            String s = br.readLine();
            if(check(s)){
                cnt++;
            }
        }

        System.out.println(cnt*(cnt-1));
    }

    public static boolean check(String s){
        int n = s.length();
        
        for(int i = 0; i < n/2; i++){
            if(s.charAt(i) != s.charAt(n-1-i)){
                return false;
            }
        }

        return true;
    }
}