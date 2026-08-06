class Solution {
    Integer[][] dp;

    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return rec(s, t, 0, 0);
    }

    int rec(String s, String t, int i, int j) {
        if (j == t.length())
            return 1;
        else if (i == s.length())
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            count = rec(s, t, i + 1, j + 1);

        }
        count += rec(s, t, i + 1, j);
        return dp[i][j] = count;
    }
}