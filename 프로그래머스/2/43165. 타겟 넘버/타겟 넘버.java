class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return dfs(numbers, 0, 0, target);
    }
    public int dfs(int[] numbers, int idx, int curr, int target){
        if(idx == numbers.length && curr == target)
            return 1;
        
        if(idx >= numbers.length)
            return 0;
        
        return dfs(numbers, idx+1, curr-numbers[idx], target) + dfs(numbers, idx+1, curr+numbers[idx], target);
    }
}