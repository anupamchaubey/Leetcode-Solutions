class Solution {
    int m, n;
    Integer[][][] memo;
    int p = 1000000007;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m][n][2];
        int x = rec(grid, 0, 0, 0);
        return x;
    }

    int rec(int[][] grid, int r, int c, int d) {
        if (r == m - 1 && c == n - 1)
            return 1;
        if (memo[r][c][d] != null)
            return memo[r][c][d];
        int count = 0;
        if (grid[r][c] == 0) {
            if (r + 1 < m) {
                count = (count + rec(grid, r + 1, c, 1)) % p;
            }
            if (c + 1 < n) {
                count = (count + rec(grid, r, c + 1, 0)) % p;
            }
        } else {
            if (d == 1) {
                if (c + 1 < n) {
                    count = (count + rec(grid, r, c + 1, 0)) % p;
                }
            } else {
                if (r + 1 < m) {
                    count = (count + rec(grid, r + 1, c, 1)) % p;
                }
            }
        }
        return memo[r][c][d] = count;

    }
}