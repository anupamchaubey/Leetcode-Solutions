class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] dp = new long[n];

        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];

            long best = Long.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                best = Math.max(best, dp[j] + j);
                left[j] = best - j;
            }
            best = Long.MIN_VALUE;

            for (int j = n - 1; j >= 0; j--) {
                best = Math.max(best, dp[j] - j);
                right[j] = best + j;
            }
            long[] newDp = new long[n];
            for (int j = 0; j < n; j++) {
                newDp[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            dp = newDp;
        }
        long max = 0;
        for (long v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }

    // long rec(int[][] points, int r, int c, long point) {
    //     if (r == points.length) {
    //         return point;
    //     }
    //     long max = Integer.MIN_VALUE;
    //     for (int i = 0; i < points[0].length; i++) {
    //         int diff = Math.abs(c - i);
    //         if (c == -1)
    //             diff = 0;
    //         max = Math.max(max, rec(points, r + 1, i, point + points[r][i] - diff));
    //     }
    //     return max;
    // }
}