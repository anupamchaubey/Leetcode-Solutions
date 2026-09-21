class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc]
                    && grid[nr][nc] == '1') {
                visited[nr][nc] = true;
                dfs(grid, nr, nc, visited);
            }
        }
    }
}