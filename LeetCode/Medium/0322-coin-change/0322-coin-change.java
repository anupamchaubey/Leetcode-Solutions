class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m + 1][n + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ans = dp[m][n];
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}