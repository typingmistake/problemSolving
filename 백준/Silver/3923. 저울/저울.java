import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);
            long d = Long.parseLong(input[2]);

            if(a==0 && b==0 && d==0) break;

            long bestCnt = Long.MAX_VALUE;
            long bestMass = Long.MAX_VALUE;
            long ansX = 0, ansY = 0;

            long limit = d / Math.min(a, b) + 10000;

            for(long x = -limit; x <= limit; x++){
                if((d - a * x) % b != 0) continue;

                long y = (d - a * x) / b;
                long cnt = Math.abs(x) + Math.abs(y);
                long mass = a * Math.abs(x) + b * Math.abs(y);

                if(cnt < bestCnt || (cnt == bestCnt && mass < bestMass)){
                    bestCnt = cnt;
                    bestMass = mass;
                    ansX = Math.abs(x);
                    ansY = Math.abs(y);
                }
            }

            sb.append(ansX).append(" ").append(ansY).append("\n");
        }

        System.out.print(sb);
    }
}