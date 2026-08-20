class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return rec(prices, 0, 0);
    }

    int rec(int[] prices, int idx, int buy) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][buy] != null)
            return dp[idx][buy];
        int max = Integer.MIN_VALUE / 2;
        if (buy == 1) {
            max = Math.max(max, prices[idx] + rec(prices, idx + 1, 0));
        } else {
            max = Math.max(max, -prices[idx] + rec(prices, idx + 1, 1));
        }
        max = Math.max(max, rec(prices, idx + 1, buy));
        return dp[idx][buy] = max;
    }
}