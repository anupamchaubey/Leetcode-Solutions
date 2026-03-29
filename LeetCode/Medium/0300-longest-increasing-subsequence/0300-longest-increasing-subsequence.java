class Solution {
    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {
        dp = new Integer[nums.length][nums.length];
        return rec(nums, -1, 0);
    }

    int rec(int[] nums, int prev, int idx) {
        if (idx == nums.length)
            return 0;
        if (prev != -1 && dp[prev][idx] != null)
            return dp[prev][idx];
        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + rec(nums, idx, idx + 1);
        }
        int nontake = rec(nums, prev, idx + 1);
        int ans = Math.max(take, nontake);
        if (prev != -1) {
            dp[prev][idx] = ans;
        }
        return ans;
    }
}