import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> ranks;
    static int[] segTree;
    public static void main(String[] args) throws IOException {
        ranks = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int idx = 0;
        int prev = sorted[0];
        ranks.put(prev, idx);

        for(int i = 1; i < N; i++) {
            if(sorted[i] != prev) {
                idx++;
                prev = sorted[i];
                ranks.put(prev, idx);
            }
        }

        int M = ranks.size();
        segTree = buildSegTree(M);
        long ans = 0;

        for(int i = 0; i < N; i++) {
            int rank = ranks.get(arr[i]);
            ans += query(rank);
            update(rank);
        }

        System.out.println(ans);
    }

    public static int[] buildSegTree(int n) {
        int m = 1;
        while(m < n) m *= 2;

        return new int[m*2];
    }

    public static void update(int idx) {
        idx += segTree.length / 2;
        segTree[idx]++;

        while(idx > 1) {
            idx /= 2;
            segTree[idx] = segTree[idx*2] + segTree[idx*2+1];
        }
    }

    public static int query(int rank) {
        int start = segTree.length/2 + rank + 1;
        int end = segTree.length - 1;
        int sum = 0;

        while(start <= end) {
            if (start % 2 == 1) sum += segTree[start++];
            if (end % 2 == 0) sum += segTree[end--];
            start /= 2;
            end /= 2;
        }

        return sum;
    }
}