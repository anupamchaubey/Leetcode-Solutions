class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return rec(prices, 0, 1, fee, dp);
    }

    int rec(int[] prices, int i, int buy, int fee, Integer[][] dp) {
        if (i == prices.length)
            return 0;
        if (dp[i][buy] != null)
            return dp[i][buy];
        int profit = 0;
        if (buy == 1) {
            profit = -prices[i] + rec(prices, i + 1, 0, fee, dp);
            profit = Math.max(profit, rec(prices, i + 1, 1, fee, dp));
        } else {
            profit = prices[i] + rec(prices, i + 1, 1, fee, dp) - fee;
            profit = Math.max(profit, rec(prices, i + 1, 0, fee, dp));
        }
        return dp[i][buy] = profit;
    }
}