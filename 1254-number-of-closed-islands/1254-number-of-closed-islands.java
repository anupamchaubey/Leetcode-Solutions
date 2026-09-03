class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    if (dfs(grid, i, j, visited))
                        c++;
                }
            }
        }
        return c;
    }

    boolean dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length)
            return false;
        if (grid[r][c] == 1 || visited[r][c])
            return true;
        visited[r][c] = true;
        boolean isIsland = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            isIsland = isIsland & dfs(grid, nr, nc, visited);
        }
        return isIsland;
    }
}