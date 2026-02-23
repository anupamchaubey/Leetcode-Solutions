class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited1 = new boolean[m][n];
                boolean[][] visited2 = new boolean[m][n];
                if (pac(heights, i, j, visited1) && atl(heights, i, j, visited2)) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    ans.add(new ArrayList<>(ls));
                }
            }
        }
        return ans;
    }

    boolean pac(int[][] heights, int r, int c, boolean[][] visited) {
        if (r == 0 || c == 0)
            return true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && heights[nr][nc] <= heights[r][c] && !visited[nr][nc]) {
                visited[nr][nc] = true;
                if (pac(heights, nr, nc, visited))
                    return true;
            }
        }
        return false;
    }

    boolean atl(int[][] heights, int r, int c, boolean[][] visited) {
        if (r == m - 1 || c == n - 1)
            return true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && heights[nr][nc] <= heights[r][c] && !visited[nr][nc]) {
                visited[nr][nc] = true;
                if (atl(heights, nr, nc, visited))
                    return true;
            }
        }
        return false;
    }
}