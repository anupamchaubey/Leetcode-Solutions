class Solution {
    int m;
    int n;
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m][n][n];
        return Math.max(0, rec(grid, 0, 0, n - 1));

    }

    int rec(int[][] grid, int r1, int c1, int c2) {
        if (r1 >= m || c1 >= n || c2 >= n || c1 < 0 || c2 < 0) {
            return Integer.MIN_VALUE;
        }
        if (r1 == m - 1) {
            if (c1 == c2)
                return grid[r1][c1];
            return grid[r1][c1] + grid[r1][c2];
        }
        if (dp[r1][c1][c2] != null)
            return dp[r1][c1][c2];
        int cherries = 0;
        if (c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r1][c2];
        }
        //(-1, 0, 1)(-1, 0, 1)

        int p1 = rec(grid, r1 + 1, c1 - 1, c2 - 1);
        p1 = Math.max(p1, rec(grid, r1 + 1, c1 - 1, c2));
        p1 = Math.max(p1, rec(grid, r1 + 1, c1 - 1, c2 + 1));

        p1 = Math.max(p1, rec(grid, r1 + 1, c1, c2 - 1));
        p1 = Math.max(p1, rec(grid, r1 + 1, c1, c2));
        p1 = Math.max(p1, rec(grid, r1 + 1, c1, c2 + 1));

        p1 = Math.max(p1, rec(grid, r1 + 1, c1 + 1, c2 - 1));
        p1 = Math.max(p1, rec(grid, r1 + 1, c1 + 1, c2));
        p1 = Math.max(p1, rec(grid, r1 + 1, c1 + 1, c2 + 1));

        cherries += p1;
        return dp[r1][c1][c2] = cherries;
    }
}