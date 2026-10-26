class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int countIslands(int[][] grid, int k) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] <= 0)
                    continue;
                visited[i][j] = true;
                long div = dfs(grid, i, j, visited);
                if (div % k == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    long dfs(int[][] grid, int r, int c, boolean[][] visited) {

        long value = grid[r][c];
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] > 0) {
                visited[nr][nc] = true;
                value += dfs(grid, nr, nc, visited);
            }
        }
        return value;
    }
}