class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int maxs = max*nums.length;
        int move = maxs - sum;
        return move;
    }
}