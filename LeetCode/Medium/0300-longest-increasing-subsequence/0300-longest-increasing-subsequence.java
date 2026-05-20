class Solution {
    int[][] dp;

    public int lengthOfLIS(int[] nums) {

        dp = new int[nums.length + 1][nums.length + 1];

        int n = nums.length;

        for(int idx = n-1; idx >= 0; idx--){
            for (int prev = idx; prev >= -1; prev--) {
                int ans = 0;
                if (prev == -1 || nums[idx] > nums[prev]) {
                    ans = 1 + dp[idx+1][idx+1];
                }
                ans = Math.max(ans, dp[idx+1][prev+1]);
                dp[idx][prev+1]=ans;
            }
        }
        return dp[0][0];
        // return rec(nums, 0, -1);
    }

    int rec(int[] nums, int idx, int prev) {
        if (idx == nums.length)
            return 0;
        if (prev != -1 && dp[idx][prev] != Integer.MAX_VALUE) {
            return dp[idx][prev];
        }
        int ans = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            ans = 1 + rec(nums, idx + 1, idx);
        }
        ans = Math.max(ans, rec(nums, idx + 1, prev));
        if (prev != -1) {
            dp[idx][prev] = ans;
        }
        return ans;
    }
}