class Solution {
    class Pair {
        int row;
        int col;
        int t;

        public Pair(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.t = t;
        }
    }

    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));
        pq.offer(new Pair(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.t;
            if (r == m - 1 && c == n - 1)
                return t;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    int nt = Math.max(grid[nr][nc], t);
                    pq.offer(new Pair(nr, nc, nt));
                }
            }
        }
        return dfs(grid, 0, 0, visited, grid[0][0]);
    }

    int dfs(int[][] grid, int r, int c, boolean[][] visited, int maxTillHere) {
        if (r == grid.length - 1 && c == grid.length - 1) {
            return maxTillHere;
        }
        int min = Integer.MAX_VALUE / 3;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc]) {
                visited[nr][nc] = true;
                min = Math.min(min, dfs(grid, nr, nc, visited, Math.max(maxTillHere, grid[nr][nc])));
                visited[nr][nc] = false;
            }
        }
        return min;
    }
}