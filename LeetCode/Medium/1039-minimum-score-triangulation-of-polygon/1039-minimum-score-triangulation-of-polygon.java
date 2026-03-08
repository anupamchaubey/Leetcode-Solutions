class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i+2;  j<n; j++) {
                
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int left = dp[i][k];
                    int right = dp[k][j];
                    int cost = values[i] * values[k] * values[j];
                    min = Math.min(min, cost + left + right);
                }
                dp[i][j]= min;
            }
        }
        return dp[0][values.length - 1];
    }

    int rec(int[] values, int st, int en) {
        if (en - st < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = st + 1; k < en; k++) {
            int left = rec(values, st, k);
            int right = rec(values, k, en);
            int cost = values[st] * values[k] * values[en];
            min = Math.min(min, cost + left + right);
        }
        return min;
    }
}