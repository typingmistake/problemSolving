import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idxA = 0;
        int idxB = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        while(idxA < A.length && idxB < B.length){
            if(A[idxA] >= B[idxB]){
                idxB++;
                continue;
            }
            answer++;
            idxA++;
            idxB++;
        }
        return answer;
    }
}