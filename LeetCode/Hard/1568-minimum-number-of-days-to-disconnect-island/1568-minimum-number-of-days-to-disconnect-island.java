class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int minDays(int[][] grid) {
        int cnt=count(grid);
        if (cnt > 1 || cnt==0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int x=count(grid);
                    if (x > 1 || x==0)
                        return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    int count(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    c++;
                }
            }
        }
        return c;
    }

    void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (grid[x][y] == 0 || visited[x][y])
            return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int r = x + dr[i];
            int c = y + dc[i];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]) {
                dfs(grid, r, c, visited);
            }
        }
    }
}