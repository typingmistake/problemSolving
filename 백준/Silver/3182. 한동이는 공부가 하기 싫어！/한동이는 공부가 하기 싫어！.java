import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer>[] sets = new HashSet[N];
        for (int i = 0; i < N; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(i+1); // 자기 자신
        }
        
        // 최대 N-1개의 연결
        for(int i = 0; i < N-1; i++){
            int[] newArr = new int[N];

            for(int j = 0; j < N; j++){
                int idx = arr[j]-1; // 이어져있는 인덱스
                sets[j].addAll(sets[idx]); // 집합 추가
                newArr[j] = arr[idx]; // 갱신
            }

            arr = newArr;
        }

        int maxIdx = 0;
        int maxSize = sets[0].size();

        for(int i = 1; i < N; i++){
            if(sets[i].size() > maxSize){
                maxIdx = i;
                maxSize = sets[i].size();
            }
        }

        System.out.println(maxIdx+1);
    }
}