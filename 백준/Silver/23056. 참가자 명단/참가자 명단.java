import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] input = sc.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<Integer, Integer> cntMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        while(true){
            input = sc.readLine().split(" ");

            if(input[0].equals("0"))
                break;

            int n = Integer.parseInt(input[0]);
            String m = input[1];

            if(cntMap.getOrDefault(n,0) < M){
                cntMap.put(n, cntMap.getOrDefault(n,0) + 1);
                result.add(String.format("%d %s", n, m));
            }
        }

        result.sort((a,b) -> {
            String[] aParts = a.split(" ");
            String[] bParts = b.split(" ");

            int aNum = Integer.parseInt(aParts[0]);
            int bNum = Integer.parseInt(bParts[0]);

            if(aNum%2 == bNum%2){
                if(aNum == bNum){
                    if(aParts[1].length() == bParts[1].length())
                        return aParts[1].compareTo(bParts[1]); // 사전순 오름차순
                    return aParts[1].length() - bParts[1].length(); // 길이 오름차순
                }
                return aNum - bNum; // 학급 오름차순
            }
            return bNum%2 - aNum%2; // 홀수 학급 우선
        });

        for(String res : result){
            System.out.println(res);
        }

    }
}
