class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    ans += dp[i + 1][j + 1];
                }
                ans += dp[i + 1][j];
                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }

    int rec(String s, String t, int i, int j, Integer[][] dp) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans += rec(s, t, i + 1, j + 1, dp);
        }
        ans += rec(s, t, i + 1, j, dp);
        return dp[i][j] = ans;
    }
}