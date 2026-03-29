class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int [] row : dp) Arrays.fill(row,-1);
        return rec(nums, -1, 0 ,dp);
    }

    int rec(int[] nums, int prev, int idx,int[][] dp) {
        if (idx >= nums.length)
            return 0;
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        int skip = rec(nums, prev, idx + 1,dp);
        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + rec(nums, idx, idx + 1,dp);
        }
        return dp[idx][prev+1] = Math.max(take, skip);
    }
}