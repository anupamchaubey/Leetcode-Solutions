class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int x : nums)
            sum += x;
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        dp = new Boolean[nums.length][sum + 1];
        return rec(nums, 0, sum);
    }

    boolean rec(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            return target == 0;
        }
        if (dp[idx][target] != null)
            return dp[idx][target];
        boolean ans = false;
        if (nums[idx] <= target) {
            ans = ans | rec(nums, idx + 1, target - nums[idx]);
        }
        ans = ans | rec(nums, idx + 1, target);
        return dp[idx][target] = ans;
    }
}