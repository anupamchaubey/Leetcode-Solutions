class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    int rec(int n, Integer[] memo) {
        if (n < 0) {
            return (int) 1e9;
        }
        if (n == 0)
            return 0;
        if (memo[n] != null)
            return memo[n];
        int min = (int) 1e9;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + rec(n - i * i, memo));
        }
        return memo[n] = min;
    }
}