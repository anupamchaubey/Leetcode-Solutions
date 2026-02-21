class Solution {
    class Pair {
        int r, c, t;

        public Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    int bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                else if (grid[i][j] == 2)
                    q.offer(new Pair(i, j, 0));
            }
        }
        if (fresh == 0)
            return 0;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int t = curr.t;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    fresh--;
                    if (fresh == 0)
                        return t + 1;
                    q.offer(new Pair(nr, nc, t + 1));
                }
            }
        }
        return -1;
    }
}