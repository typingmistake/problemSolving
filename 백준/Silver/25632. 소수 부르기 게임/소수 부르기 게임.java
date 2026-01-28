import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 2; i++){
            max = Math.max(max, A[i]);
            max = Math.max(max, B[i]);
            min = Math.min(min, A[i]);
            min = Math.min(min, B[i]);
        }

        boolean[] isPrime = setIsPrime(max);
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        for(int i = min; i <= max; i++){
            if(!isPrime[i]) continue;
            if(A[0] <= i && i <= A[1]) listA.add(i);
            if(B[0] <= i && i <= B[1]) listB.add(i);
            if(Math.max(A[0], B[0]) <= i && i <= Math.min(A[1], B[1]))
                listC.add(i);
        }
        int cntA = listA.size() - listC.size();
        int cntB = listB.size() - listC.size();
        cntA += listC.size()%2 == 1 ? listC.size()/2 + 1 : listC.size()/2;
        cntB += listC.size()/2;

        System.out.println(cntA > cntB ? "yt" : "yj");
    }
    public static boolean[] setIsPrime(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i <= n; i++){
            if(!isPrime[i]) continue;

            for(int j = i*i; j <= n; j += i){
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
}