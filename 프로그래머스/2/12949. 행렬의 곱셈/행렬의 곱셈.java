class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer[i][j] = calc(arr1, arr2, i, j);
            }
        }
        
        return answer;
    }
    
    public static int calc(int[][] matA, int[][] matB, int r, int c){
        int len = matA[0].length;
        int res = 0;
        for(int i = 0; i < len; i++){
            res += matA[r][i] * matB[i][c];
        }
        
        return res;
    }
}