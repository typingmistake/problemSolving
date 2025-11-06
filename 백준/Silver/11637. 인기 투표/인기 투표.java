import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int maxCand = 0;
            int maxVal = 0;
            int sumVal = 0;
            int maxCnt = 1;

            for(int i = 1; i <= N; i++){
                int num = Integer.parseInt(br.readLine());
                sumVal += num;
                if(num > maxVal){
                    maxCand = i;
                    maxVal = num;
                    maxCnt = 1;
                }else if(num == maxVal){
                    maxCnt++;
                }
            }

            if(maxVal > sumVal/2){
                System.out.println("majority winner "+maxCand);
                continue;
            }

            if(maxCnt > 1){
                System.out.println("no winner");
                continue;
            }
            
            System.out.println("minority winner "+maxCand);
        }
    }
}