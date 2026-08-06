class Solution {
    Integer[][] dp;

    public int minInsertions(String s) {
        dp = new Integer[s.length()][s.length()];
        return rec(s, 0, s.length() - 1);
    }

    int rec(String s, int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int min = Integer.MAX_VALUE;

        if (s.charAt(i) == s.charAt(j)) {
            min = rec(s, i + 1, j - 1);
        } else {
            min = Math.min(1 + rec(s, i + 1, j), 1 + rec(s, i, j - 1));
        }
        return dp[i][j] = min;
    }
}