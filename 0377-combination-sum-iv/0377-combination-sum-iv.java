class Solution {
    Integer[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        return rec(nums, target);

    }

    int rec(int[] nums, int sum) {
        if (sum == 0)
            return 1;
        if (dp[sum] != null)
            return dp[sum];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= nums[i]) {
                cnt += rec(nums, sum - nums[i]);
            }
        }
        return dp[sum] = cnt;
    }
}