class Solution {
    int rows;
    int cols;

    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1,1 };
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
        boolean closed=true;
        for(int p=0;p<4;p++){
            int r=i+dr[p];
            int c=j+dc[p];
            closed&=dfs(grid, r, c);
        }
        return closed;

    }
}