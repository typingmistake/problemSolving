import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            solve(i, i);
        }

        list.sort(Long::compareTo); // 오름차순 정렬

        if(N >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N));
        }
    }
    public static void solve(long curr, int last){
        list.add(curr);
        for(int i = 0; i < last; i++){
            solve(curr*10 + i, i);
        }
    }
}