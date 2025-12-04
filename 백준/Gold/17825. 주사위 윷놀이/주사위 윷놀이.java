import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int[] players;
    static int[] scores;
    static Map<Integer, Integer> redDir;
    static Map<Integer, Integer> blueDir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        answer = Integer.MIN_VALUE;
        players = new int[4]; // 4개의 말, 시작 칸 0
        scores = new int[34];
        redDir = new HashMap<>();
        blueDir = new HashMap<>();

        // 점수 설정
        for(int i = 0; i <= 20; i++){
            redDir.put(i, i+1);
            scores[i] = i * 2;
        }

        scores[21] = -1; // 도착 칸

        // 하 -> 상
        blueDir.put(10, 22);

        redDir.put(22, 23);
        scores[22] = 22;
        redDir.put(23, 24);
        scores[23] = 24;
        redDir.put(24, 25);
        scores[24] = 25;

        redDir.put(25, 26);
        scores[25] = 30;
        redDir.put(26, 20);
        scores[26] = 35;


        // 좌 -> 우
        blueDir.put(5, 28);

        redDir.put(28, 29);
        scores[28] = 13;
        redDir.put(29, 30);
        scores[29] = 16;
        redDir.put(30, 24);
        scores[30] = 19;

        // 우 -> 좌
        blueDir.put(15, 31);

        redDir.put(31, 32);
        scores[31] = 28;
        redDir.put(32, 33);
        scores[32] = 27;
        redDir.put(33, 24);
        scores[33] = 26;

        solve(0, 0, arr);
        System.out.println(answer);
    }
    public static void solve(int depth, int score, int[] arr){
        if(depth == 10){
            answer = Math.max(answer, score);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int curr = players[i];
            int move = arr[depth];
            if(scores[curr] == -1) continue; // 도착 칸이면 패스

            if(blueDir.containsKey(curr)){
                curr = blueDir.get(curr);
                move--;
            }

            while(move-- > 0){
                if(!redDir.containsKey(curr)) break; // 도착 칸 도달
                curr = redDir.get(curr);
            }

            // 다른 말이 있는 칸이면 패스
            if(scores[curr] != -1 && !check(curr,  players)) continue;

            int temp = players[i];
            players[i] = curr;
            solve(depth + 1, scores[curr] == -1 ? score : score + scores[curr], arr);
            players[i] = temp;
        }
    }

    public static boolean check(int curr, int[] players){
        for(int i = 0; i < 4; i++){
            if(players[i] == curr) return false;
        }

        return true;
    }
}