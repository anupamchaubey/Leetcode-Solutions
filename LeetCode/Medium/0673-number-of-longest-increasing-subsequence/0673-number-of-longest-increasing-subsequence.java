class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    if (dp[i] == dp[prev] + 1) {
                        cnt[i] += cnt[prev];
                    } else if (dp[prev] + 1 > dp[i]) {
                        dp[i] = dp[prev] + 1;
                        cnt[i] = cnt[prev];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max)
                count += cnt[i];
        }
        return count;
    }
}