class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][amount] = 1;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int sum = amount - 1; sum >= 0; sum--) {
                int ans = 0;
                if (coins[i] + sum <= amount) {
                    ans += dp[i][sum + coins[i]];

                }
                ans += dp[i + 1][sum];
                dp[i][sum] = ans;
            }
        }
        return dp[0][0];

    }

    int rec(int[] coins, int i, int sum, int amount) {

        if (sum == amount)
            return 1;
        if (i == coins.length)
            return 0;
        int ans = 0;
        if (coins[i] + sum <= amount) {
            ans += rec(coins, i, sum + coins[i], amount);
        }
        ans += rec(coins, i + 1, sum, amount);
        return ans;
    }
}