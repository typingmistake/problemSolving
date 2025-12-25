import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int dir; // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        Set<String> apples = new HashSet<>();

        for(int i = 0; i < K; i++){
            String[] line = br.readLine().split(" ");
            int r = Integer.parseInt(line[0]) - 1;
            int c = Integer.parseInt(line[1]) - 1;
            apples.add(r + " " + c);
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Integer> turns = new HashMap<>();

        for(int i = 0; i < L; i++){
            String[] line = br.readLine().split(" ");
            int time = Integer.parseInt(line[0]);
            int turn = line[1].equals("D") ? 1 : -1;
            turns.put(time, turn);
        }

        Deque<String> dq = new ArrayDeque<>();
        dq.add("0 0");
        int[] head = {0, 0};
        dir = 0; // 처음 방향은 오른쪽
        int t = 0; // 시간

        while(true){
            t+=1;
            head[0] += dx[dir];
            head[1] += dy[dir];
            String pos = head[0] + " " + head[1];

            if(head[0] < 0 || head[0] >= N || head[1] < 0 || head[1] >= N || dq.contains(pos)){
                System.out.println(t);
                return;
            }

            if(turns.containsKey(t)) dir = (dir + turns.get(t) + 4) % 4;
            dq.addLast(pos);

            if(apples.contains(pos)){
                apples.remove(pos);
                continue;
            }

            dq.pollFirst();
        }

    }
}