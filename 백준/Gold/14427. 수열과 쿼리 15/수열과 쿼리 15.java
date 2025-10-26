import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        int[] nums = Arrays.stream(sc.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] segTree = segTree(nums);
        int M = Integer.parseInt(sc.readLine());

        while(M-- > 0){
            String[] command = sc.readLine().split(" ");
            if(command[0].equals("2")){
                System.out.println(segTree[1]+1);
                continue;
            }
            int idx = Integer.parseInt(command[1]) - 1;
            int val = Integer.parseInt(command[2]);
            changeLeaf(nums, segTree, idx, val);
        }
    }
    public static int[] segTree(int[] nums) {
        int n = nums.length, m = 1;
        while(m < n) m *= 2;
        int[] tree = new int[m * 2];
        Arrays.fill(tree, -1);

        for(int i = 0; i < n; i++) {
            tree[m + i] = i;
        }

        for(int i = m-1; i >= 1; i--){
            int left = i*2, right = i*2+1;
            if(tree[left] == -1)
                tree[i] = tree[right];
            else if(tree[right] == -1)
                tree[i] = tree[left];
            else{
                // 더 작은 쪽의 인덱스를 저장
                if(nums[tree[left]] <= nums[tree[right]])
                    tree[i] = tree[left]; // 같을 때는 왼쪽
                else
                    tree[i] = tree[right];
            }
        }

        return tree;
    }

    public static void changeLeaf(int[] nums, int[] tree, int idx, int val){
        nums[idx] = val;
        int m = tree.length / 2;
        idx = (idx + m) / 2;
        
        while(idx >= 1){
            int left = idx*2, right = idx*2+1;
            if(tree[left] == -1)
                tree[idx] = tree[right];
            else if(tree[right] == -1)
                tree[idx] = tree[left];
            else{
                // 더 작은 쪽의 인덱스를 저장
                if(nums[tree[left]] <= nums[tree[right]])
                    tree[idx] = tree[left];
                else
                    tree[idx] = tree[right];
            }
            idx /= 2;
        }
    }
}
