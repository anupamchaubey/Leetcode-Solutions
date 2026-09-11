class Solution {
    Integer[][] dp;

    public int maxCoins(int[] nums) {
        dp = new Integer[nums.length][nums.length];
        return rec(nums, 0, nums.length - 1);
    }

    int rec(int[] nums, int st, int en) {
        if (en < 0 || st == nums.length || st > en)
            return 0;
        if (dp[st][en] != null)
            return dp[st][en];
        int max = 0;
        for (int i = st; i <= en; i++) {
            int l = rec(nums, st, i - 1);
            int r = rec(nums, i + 1, en);
            int cost = nums[i] * ((st - 1 >= 0) ? nums[st - 1] : 1)
                    * ((en + 1 < nums.length) ? nums[en + 1] : 1);
            max = Math.max(max, cost + l + r);
        }
        return dp[st][en] = max;
    }
}