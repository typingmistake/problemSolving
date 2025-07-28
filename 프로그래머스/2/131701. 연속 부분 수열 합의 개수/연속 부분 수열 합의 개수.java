import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int curr = 0;
        int n = elements.length;
        
        for(int i = 0; i < n; i++){
            elements[i]+=curr;
            curr=elements[i];
        }
        
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                set.add(calcSum(elements, i, l, n));
            }
        }
        
            
        return set.size();
    }
    
    public static int calcSum(int[] elems, int s, int len, int n){
        int end = s+len-1;
        int res = elems[end%n];
        
        if( end >= n )
            res += elems[n-1];
        
        if(s > 0)
            res -= elems[s-1];
        
        return res;
    }
}