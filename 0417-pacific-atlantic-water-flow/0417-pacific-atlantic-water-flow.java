class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (pac(grid, i, j, new boolean[grid.length][grid[0].length])
                        && atl(grid, i, j, new boolean[grid.length][grid[0].length])) {
                    ans.add(new ArrayList(Arrays.asList(i, j)));
                }
            }
        }
        return ans;
    }

    boolean pac(int[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr == grid.length || nc == grid[0].length)
                continue;
            if (nr < 0 || nc < 0)
                return true;
            if (grid[nr][nc] <= grid[r][c] && !visited[nr][nc]) {

                if (pac(grid, nr, nc, visited))
                    return true;
            }
        }
        return false;
    }

    boolean atl(int[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr == grid.length || nc == grid[0].length)
                return true;
            if (nr < 0 || nc < 0)
                continue;
            if (grid[nr][nc] <= grid[r][c] && !visited[nr][nc]) {
                if (atl(grid, nr, nc, visited))
                    return true;
            }
        }
        return false;
    }
}