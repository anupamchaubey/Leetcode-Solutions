class Solution {
    Boolean[][] dp;

    public boolean winnerSquareGame(int n) {
        dp = new Boolean[n + 1][2];

        return rec(n, 1);
    }

    boolean rec(int n, int alice) {
        if (n == 0)
            if (alice == 0)
                return true;
        if (dp[n][alice] != null)
            return dp[n][alice];
        if (alice == 1) {
            boolean ans = false;
            for (int i = 1; i * i <= n; i++) {
                ans = ans | rec(n - i * i, 0);
            }
            return dp[n][alice] = ans;
        } else {
            boolean ans = true;
            for (int i = 1; i * i <= n; i++) {
                ans = ans & rec(n - i * i, 1);
            }
            return dp[n][alice] = ans;
        }
    }
}