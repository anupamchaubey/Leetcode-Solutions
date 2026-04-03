class Solution {
    int m;
    int n;
    int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0)
            return -1;
        return bfs(grid);
    }

    int bfs(int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        int t = 1;
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int size = q.size();
            for (int p = 0; p < size; p++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == m - 1 && c == n - 1) {
                    return t;
                }
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[] { nr, nc});
                    }
                }
            }
            t+=1;
        }
        return -1;
    }
}