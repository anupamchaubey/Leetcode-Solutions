class Solution {
    Integer[][][] dp;

    public int maxProfit(int k, int[] prices) {
        dp = new Integer[prices.length][2][k + 1];
        return rec(prices, 0, 0, k);
    }

    int rec(int[] prices, int idx, int buy, int txn) {
        if (idx == prices.length)
            return 0;
        if (txn == 0)
            return 0;
        if (dp[idx][buy][txn] != null)
            return dp[idx][buy][txn];
        int max = 0;
        if (buy == 1) {
            max = Math.max(max, prices[idx] + rec(prices, idx + 1, 0, txn - 1));
        } else {
            max = Math.max(max, -prices[idx] + rec(prices, idx + 1, 1, txn));
        }
        max = Math.max(max, rec(prices, idx + 1, buy, txn));
        return dp[idx][buy][txn] = max;
    }
}