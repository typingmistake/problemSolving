import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int SIZE = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] checked = new boolean[SIZE][SIZE]; // 초기값은 false
        Map<Integer, int[]> positions = new HashMap<>();

        for (int i = 0; i < SIZE; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < SIZE; j++){
                positions.put(nums[j], new int[]{i, j});
            }
        }

        for(int i = 0; i < 5; i++){
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < 5; j++){
                int[] pos = positions.get(nums[j]);
                checked[pos[0]][pos[1]] = true;
                if(checkBingo(checked)){
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }
    }
    public static boolean checkBingo(boolean[][] checked){
        int bingoCount = 0;

        // 가로 체크
        for(int i = 0; i < SIZE; i++){
            boolean isBingo = true;
            for(int j = 0; j < SIZE; j++){
                if(!checked[i][j]){
                    isBingo = false;
                    break;
                }
            }
            if(isBingo) bingoCount++;
        }

        // 세로 체크
        for(int j = 0; j < SIZE; j++){
            boolean isBingo = true;
            for(int i = 0; i < SIZE; i++){
                if(!checked[i][j]){
                    isBingo = false;
                    break;
                }
            }
            if(isBingo) bingoCount++;
        }

        // 대각선 체크
        boolean isBingo = true;
        for(int i = 0; i < SIZE; i++){
            if(!checked[i][i]){
                isBingo = false;
                break;
            }
        }
        if(isBingo) bingoCount++;

        isBingo = true;
        for(int i = 0; i < SIZE; i++){
            if(!checked[i][SIZE - 1 - i]){
                isBingo = false;
                break;
            }
        }
        if(isBingo) bingoCount++;

        return bingoCount >= 3;
    }
}
