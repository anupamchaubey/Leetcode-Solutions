class Solution {
    Integer[][] dp;

    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return rec(coins, 0, amount);
    }

    int rec(int[] coins, int idx, int sum) {
        if (idx == coins.length) {
            if (sum == 0)
                return 1;
            return 0;
        }
        if (dp[idx][sum] != null)
            return dp[idx][sum];
        int max = 0;
        if (sum >= coins[idx]) {
            max += rec(coins, idx, sum - coins[idx]);
        }
        max += rec(coins, idx + 1, sum);
        return dp[idx][sum] = max;
    }
}