class Solution {
    Integer[][] dp;

    public int stoneGameII(int[] piles) {

        int n = piles.length;
        dp = new Integer[n][n];

        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return rec(piles, 0, 1, suffix);
    }

    int rec(int[] piles, int idx, int m, int[] suffix) {
        if (idx == piles.length)
            return 0;
        if (idx + 2 * m >= piles.length)
            return suffix[idx];
        if (dp[idx][m] != null)
            return dp[idx][m];
        int max = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int newM = Math.max(m, i);
            int curr = suffix[idx] - rec(piles, idx + i, newM, suffix);
            max = Math.max(max, curr);
        }
        return dp[idx][m] = max;
    }
}