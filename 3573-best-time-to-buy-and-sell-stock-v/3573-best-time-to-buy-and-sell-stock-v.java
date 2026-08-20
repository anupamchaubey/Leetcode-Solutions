class Solution {
    Long[][][] dp;

    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length][3][k + 1];
        return rec(prices, 0, 0, k);
    }

    //buy==1 means earlier purchased now u have to sell
    //buy==0 means not purchased earlier u can purchase
    //buy==2 means item already sold now u have to purchase

    long rec(int[] prices, int idx, int buy, int txn) {
        if (idx == prices.length) {
            if (buy == 0)
                return 0;
            else
                return Long.MIN_VALUE / 2;
        }
        if (dp[idx][buy][txn] != null)
            return dp[idx][buy][txn];
        long max = rec(prices, idx + 1, buy, txn);
        if (buy == 1 && txn > 0) {
            max = Math.max(max, prices[idx] + rec(prices, idx + 1, 0, txn - 1));
        } else if (buy == 2 && txn > 0) {
            max = Math.max(max, -prices[idx] + rec(prices, idx + 1, 0, txn - 1));
        } else if (buy == 0 && txn > 0) {
            max = Math.max(max, -prices[idx] + rec(prices, idx + 1, 1, txn));
            max = Math.max(max, prices[idx] + rec(prices, idx + 1, 2, txn));
        }
        return dp[idx][buy][txn] = max;
    }
}