class Solution {
    Integer[][] dp;

    public int longestPalindromeSubseq(String s) {
        dp = new Integer[s.length()][s.length()];
        String s2 = new StringBuilder(s).reverse().toString();
        return rec(s, s2, 0, 0);
    }

    int rec(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int max = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            max = 1 + rec(s1, s2, i + 1, j + 1);
        } else {
            max = rec(s1, s2, i + 1, j);
            max = Math.max(max, rec(s1, s2, i, j + 1));
        }
        return dp[i][j] = max;
    }
}