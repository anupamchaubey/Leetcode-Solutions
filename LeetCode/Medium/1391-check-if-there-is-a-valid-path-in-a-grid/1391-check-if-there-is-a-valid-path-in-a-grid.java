class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    int m;
    int n;

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        return dfs(grid, 0, 0, visited);
    }

    boolean dfs(int[][] grid, int r, int c, boolean[][] visited) {

        if (r == m - 1 && c == n - 1)
            return true;

        if (grid[r][c] == 1) {
            if (c + 1 < n && !visited[r][c + 1]
                    && (grid[r][c + 1] == 1 || grid[r][c + 1] == 3 || grid[r][c + 1] == 5)) {
                visited[r][c + 1] = true;
                if (dfs(grid, r, c + 1, visited))
                    return true;
            }
            if (c - 1 >= 0 && !visited[r][c - 1]
                    && (grid[r][c - 1] == 1 || grid[r][c - 1] == 4 || grid[r][c - 1] == 6)) {
                if (dfs(grid, r, c - 1, visited))
                    return true;
            }
        } else if (grid[r][c] == 2) {
            if (r - 1 >= 0 && !visited[r - 1][c]
                    && (grid[r - 1][c] == 2 || grid[r - 1][c] == 3 || grid[r - 1][c] == 4)) {
                visited[r - 1][c] = true;
                if (dfs(grid, r - 1, c, visited))
                    return true;
            }
            if (r + 1 < m && !visited[r + 1][c]
                    && (grid[r + 1][c] == 2 || grid[r + 1][c] == 5 || grid[r + 1][c] == 6)) {
                visited[r + 1][c] = true;
                if (dfs(grid, r + 1, c, visited))
                    return true;
            }
        } else if (grid[r][c] == 3) {
            if (c - 1 >= 0 && !visited[r][c - 1]
                    && (grid[r][c - 1] == 1 || grid[r][c - 1] == 4 || grid[r][c - 1] == 6)) {
                visited[r][c - 1] = true;
                if (dfs(grid, r, c - 1, visited))
                    return true;
            }
            if (r + 1 < m && !visited[r + 1][c]
                    && (grid[r + 1][c] == 2 || grid[r + 1][c] == 5 || grid[r + 1][c] == 6)) {
                visited[r + 1][c] = true;
                if (dfs(grid, r + 1, c, visited))
                    return true;
            }
        } else if (grid[r][c] == 4) {
            if (c + 1 < n && !visited[r][c + 1]
                    && (grid[r][c + 1] == 1 || grid[r][c + 1] == 3 || grid[r][c + 1] == 5)) {
                visited[r][c + 1] = true;
                if (dfs(grid, r, c + 1, visited))
                    return true;
            }
            if (r + 1 < m && !visited[r + 1][c]
                    && (grid[r + 1][c] == 2 || grid[r + 1][c] == 5 || grid[r + 1][c] == 6)) {
                visited[r + 1][c] = true;
                if (dfs(grid, r + 1, c, visited))
                    return true;
            }
        } else if (grid[r][c] == 5) {
            if (r - 1 >= 0 && !visited[r - 1][c]
                    && (grid[r - 1][c] == 2 || grid[r - 1][c] == 3 || grid[r - 1][c] == 4)) {
                visited[r - 1][c] = true;
                if (dfs(grid, r - 1, c, visited))
                    return true;
            }
            if (c - 1 >= 0 && !visited[r][c - 1]
                    && (grid[r][c - 1] == 1 || grid[r][c - 1] == 4 || grid[r][c - 1] == 6)) {
                visited[r][c - 1] = true;
                if (dfs(grid, r, c - 1, visited))
                    return true;
            }
        } else if (grid[r][c] == 6) {
            if (r - 1 >= 0 && !visited[r - 1][c]
                    && (grid[r - 1][c] == 2 || grid[r - 1][c] == 3 || grid[r - 1][c] == 4)) {
                visited[r - 1][c] = true;
                if (dfs(grid, r - 1, c, visited))
                    return true;
            }
            if (c + 1 < n && !visited[r][c + 1]
                    && (grid[r][c + 1] == 1 || grid[r][c + 1] == 3 || grid[r][c + 1] == 5)) {
                visited[r][c + 1] = true;
                if (dfs(grid, r, c + 1, visited))
                    return true;
            }
        }
        return false;
    }
}