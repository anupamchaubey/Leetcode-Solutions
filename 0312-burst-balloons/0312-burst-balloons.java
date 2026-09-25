class Solution {
    Integer[][] dp;

    public int maxCoins(int[] nums) {
        dp = new Integer[nums.length][nums.length];
        return rec(nums, 0, nums.length - 1);
    }

    int rec(int[] nums, int st, int en) {
        if (st > en)
            return 0;
        if (dp[st][en] != null)
            return dp[st][en];
        int max = 0;
        for (int i = st; i <= en; i++) {
            int left = rec(nums, st, i - 1);
            int right = rec(nums, i + 1, en);
            int val = ((st - 1 >= 0) ? nums[st - 1] : 1) * ((en + 1 < nums.length) ? nums[en + 1] : 1) * nums[i];
            max = Math.max(max, val + left + right);
        }
        return dp[st][en] = max;
    }
}