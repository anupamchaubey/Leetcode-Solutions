class Solution {

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return rec(n, costs, 0, dp);
    }

    int rec(int n, int[] costs, int idx, int[] dp) {
        if (idx > n)
            return Integer.MAX_VALUE / 3;
        if (idx == n)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int min = costs[idx] + 1 + rec(n, costs, idx + 1, dp);
        if (idx + 1 < n)
            min = Math.min(min, costs[idx + 1] + 4 + rec(n, costs, idx + 2, dp));
        if (idx + 2 < n)
            min = Math.min(min, costs[idx + 2] + 9 + rec(n, costs, idx + 3, dp));
        return dp[idx] = min;
    }
}