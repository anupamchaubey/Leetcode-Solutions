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
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));
        pq.offer(new Pair(0, 0, grid[0][0]));
        boolean[][] visited=new boolean[m][n];
        visited[0][0]=true;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.t;
            if(r==m-1 && c==n-1)return t;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                    visited[nr][nc]=true;
                    int nt=Math.max(grid[nr][nc], t);
                    pq.offer(new Pair(nr, nc, nt));
                }
            }
        }
        return -1;
    }
}