import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        while(C-- > 0){
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);

            // N > M, K-N은 최대 얻을 수 있는 배점
            if(N > M && (N-1)-M >= K-(N-1)){
                System.out.println(0);
                continue;
            }

            // M > N, K-M+1이 최대 얻을 수 있는 배점
            if(M > N && (M-1)-N >= K-(M-1)+1){
                System.out.println(0);
                continue;
            }

            System.out.println(1);
        }
    }
}