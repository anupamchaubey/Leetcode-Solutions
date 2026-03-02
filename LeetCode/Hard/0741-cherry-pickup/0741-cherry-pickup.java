class Solution {
    int n;
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp=new Integer[n][n][n];
        if (grid[0][0] == -1 || grid[n - 1][n - 1] == -1)
            return 0;
        return Math.max(0, pick(grid, 0, 0, 0));
    }

    int pick(int[][] grid, int r1, int c1, int r2) {
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE / 2;
        if( dp[r1][c1][r2]!=null)return dp[r1][c1][r2];
        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        int p1 = pick(grid, r1 + 1, c1, r2 + 1);
        int p2 = pick(grid, r1, c1 + 1, r2 + 1);
        int p3 = pick(grid, r1, c1 + 1, r2);
        int p4 = pick(grid, r1 + 1, c1, r2);
        cherries += Math.max(Math.max(p1, p2), Math.max(p3, p4));
        return dp[r1][c1][r2]= cherries;
    }
}