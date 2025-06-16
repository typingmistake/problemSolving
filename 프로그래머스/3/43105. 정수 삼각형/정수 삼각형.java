class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        for(int i = h-2; i >= 0; i--){
            int w = triangle[i].length;
            for(int j = 0; j < w; j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            } 
        }
        return triangle[0][0];
            
            
    }
}