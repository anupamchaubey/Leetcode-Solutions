class Solution {
    int rows;
    int cols;

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols)
            return false;

        if (grid[i][j] == 1)
            return true;

        grid[i][j] = 1;
        boolean left = dfs(grid, i, j - 1);
        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean right = dfs(grid, i, j + 1);
        return left && right && up && down;

    }
}