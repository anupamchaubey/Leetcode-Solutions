class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        int[][][] dist = new int[m][n][k + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 0;

        // row, col, steps, obstacles
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        q.offer(new int[] { 0, 0, 0, 0 });
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int s = arr[2];
            int o = arr[3];
            if (o > k)
                continue;
            if (s > dist[r][c][o])
                continue;

            if (r == m - 1 && c == n - 1) {
                return s;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int no = 0;
                    if (grid[nr][nc] == 1)
                        no = 1;
                    no += o;
                    if (s + 1 < dist[nr][nc][no]) {
                        dist[nr][nc][no] = s + 1;
                        q.offer(new int[] { nr, nc, s + 1, no });
                    }
                }
            }
        }
        return -1;
    }
}