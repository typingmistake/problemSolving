import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] segTree = build(arr, N);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int cmd = Integer.parseInt(line[0]);
            if(cmd == 1){
                int idx = Integer.parseInt(line[1]) - 1;
                int val = Integer.parseInt(line[2]);
                replace(segTree, idx+segTree.length/2, val);
                continue;
            }

            int l = Integer.parseInt(line[1]) - 1;
            int r = Integer.parseInt(line[2]) - 1;

            int[] res = query(segTree, l, r);
            System.out.println(res[1] + 1);
        }

    }
    public static int[][] build(int[] arr, int n){
        int m = 2;
        while(m < n) m *= 2;
        int[][] tree = new int[m * 2][2]; // 최소값, 인덱스

        for(int i = 0; i < tree.length; i++){
            tree[i][0] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++){
            tree[m + i][0] = arr[i];
            tree[m + i][1] = i;
        }

        for(int i = m-1; i > 0; i--){
            if(tree[i*2][0] <= tree[i*2+1][0]){
                tree[i][0] = tree[i*2][0];
                tree[i][1] = tree[i*2][1];
                continue;
            }

            tree[i][0] = tree[i*2+1][0];
            tree[i][1] = tree[i*2+1][1];
        }

        return tree;
    }

    public static void replace(int[][] tree, int idx, int val){
        tree[idx][0] = val;
        int pos = idx / 2;

        while(pos > 0){
            int l = pos*2;
            int r = pos*2 + 1;

            if(tree[l][0] < tree[r][0] || (tree[l][0] == tree[r][0] && tree[l][1] <= tree[r][1])){
                tree[pos][0] = tree[l][0];
                tree[pos][1] = tree[l][1];
            } else {
                tree[pos][0] = tree[r][0];
                tree[pos][1] = tree[r][1];
            }
            pos /= 2;
        }
    }

    public static int[] query(int[][] tree, int l, int r){
        int m = tree.length / 2;
        l += m;
        r += m;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while(l <= r){
            if(l%2 == 1){
                if(tree[l][0] < minVal || (tree[l][0] == minVal && tree[l][1] < minIdx)){
                    minVal = tree[l][0];
                    minIdx = tree[l][1];
                }
                l++;
            }
            if(r%2 == 0){
                if(tree[r][0] < minVal || (tree[r][0] == minVal && tree[r][1] < minIdx)){
                    minVal = tree[r][0];
                    minIdx = tree[r][1];
                }
                r--;
            }
            l /= 2;
            r /= 2;
        }

        return new int[]{minVal, minIdx};
    }
}