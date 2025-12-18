import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] probs = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double ans = 0.0;

        ans += probs[0];
        for(int i = 1; i < N; i++){
            ans += probs[i];
            ans += (1-probs[i-1])*probs[i];
            ans += (1-probs[i])*probs[i-1];
        }

        System.out.println(ans);
    }
}