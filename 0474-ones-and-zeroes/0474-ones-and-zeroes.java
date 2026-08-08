class Solution {
    int[] one;
    Integer[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length][m + 1][n + 1];
        this.one = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (char ch : strs[i].toCharArray()) {
                if (ch == '1')
                    one[i]++;
            }
        }
        return rec(strs, 0, m, n);
    }

    int rec(String[] strs, int idx, int m, int n) {
        if (idx == strs.length)
            return 0;
        if (dp[idx][m][n] != null)
            return dp[idx][m][n];
        int max = 0;
        int z = Math.abs(one[idx] - strs[idx].length());
        int o = one[idx];
        if (n >= o && m >= z) {
            max = 1 + rec(strs, idx + 1, m - z, n - o);
        }
        max = Math.max(max, rec(strs, idx + 1, m, n));
        return dp[idx][m][n] = max;
    }

}