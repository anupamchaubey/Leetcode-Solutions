class Solution {
    Integer[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[coins.length][amount + 1];
        int x = rec(coins, 0, amount);
        if (x == Integer.MAX_VALUE / 3)
            return -1;
        return x;
    }

    int rec(int[] coins, int idx, int sum) {
        if (idx == coins.length) {
            if (sum == 0)
                return 0;
            else
                return Integer.MAX_VALUE / 3;
        }
        if (dp[idx][sum] != null)
            return dp[idx][sum];
        int min = Integer.MAX_VALUE / 3;
        if (sum >= coins[idx]) {
            min = 1 + rec(coins, idx, sum - coins[idx]);
        }
        min = Math.min(min, rec(coins, idx + 1, sum));
        return dp[idx][sum] = min;
    }
}