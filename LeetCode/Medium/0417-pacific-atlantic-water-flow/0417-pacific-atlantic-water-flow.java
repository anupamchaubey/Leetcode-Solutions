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
                if (pacific(heights, i, j) && atlantic(heights, i, j)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    boolean pacific(int[][] heights, int r, int c) {
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        visited[r][c]=true;
        q.offer(new int[] { r, c });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == 0 || p[1] == 0)
                return true;
            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && heights[nr][nc] <= heights[p[0]][p[1]]) {
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;

        
    }

    boolean atlantic(int[][] heights, int r, int c) {
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        visited[r][c]=true;
        q.offer(new int[] { r, c });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == m-1 || p[1] == n-1)
                return true;
            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && heights[nr][nc] <= heights[p[0]][p[1]]) {
                    visited[nr][nc]=true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}