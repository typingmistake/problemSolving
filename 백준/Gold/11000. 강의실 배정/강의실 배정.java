import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[2*N][2]; // 시간, 값

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            times[2*i] = new int[]{Integer.parseInt(line[0]), 1}; // 강의 시작
            times[2*i+1] = new int[]{Integer.parseInt(line[1]), -1}; // 강의 종료
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        int result = 0;
        int answer = 0;
        int curr = times[0][1]; // 현재 시각 값
        int prevTime = times[0][0];

        for(int i = 1; i < 2*N; i++){
            if(times[i][0] == prevTime){
                curr += times[i][1]; // 누적만
                continue;
            }

            result += curr;
            answer = Math.max(answer, result);

            // 시간 변경
            prevTime = times[i][0];
            curr = times[i][1];
        }

        System.out.println(Math.max(answer, result+curr));
    }
}