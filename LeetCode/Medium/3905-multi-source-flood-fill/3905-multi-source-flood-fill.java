class Solution {
    public int[][] colorGrid(int m, int n, int[][] sources) {

        int grid[][] = new int[m][n];

        Arrays.sort(sources, (a, b)-> b[2]-a[2]);

        Queue<int[]> q = new LinkedList<>();
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < sources.length; i++) {
            int r = sources[i][0];
            int c = sources[i][1];
            int color = sources[i][2];
            q.offer(new int[] { r, c, color });
            grid[r][c] = color;
            visited[r][c] = true;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                int c = arr[2];
                for (int p = 0; p < 4; p++) {
                    int nr = i + dr[p];
                    int nc = j + dc[p];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        grid[nr][nc] = Math.max(grid[nr][nc], c);
                        q.offer(new int[] { nr, nc, grid[nr][nc]});
                        visited[nr][nc]=true;
                    }
                }
            }
        }
        return grid;
    }
}