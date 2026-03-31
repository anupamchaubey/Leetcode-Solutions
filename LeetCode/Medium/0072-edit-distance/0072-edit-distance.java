class Solution {
    int[][] dp;
    public int minDistance(String s1, String s2) {
        dp=new int[s1.length()][s2.length()];
        for(int[] arr: dp)Arrays.fill(arr, -1);
        return rec(s1, s2, 0, 0);
    }

    int rec(String s1, String s2, int i, int j) {
        if (j == s2.length()) {
            return s1.length() - i;
        }
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return rec(s1, s2, i + 1, j + 1);
        } else {
            return dp[i][j]= Math.min(1 + rec(s1, s2, i + 1, j),
                    Math.min(1 + rec(s1, s2, i, j + 1), 1 + rec(s1, s2, i + 1, j + 1)));
        }
    }
}