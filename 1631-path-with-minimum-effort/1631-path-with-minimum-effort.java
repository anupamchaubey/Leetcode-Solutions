class Solution {
    class Pair {
        int x;
        int y;
        long effort;

        public Pair(int x, int y, long effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }

    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        long[][] efforts = new long[m][n];
        for (long[] eff : efforts) {
            Arrays.fill(eff, Long.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.effort, b.effort));
        q.offer(new Pair(0, 0, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.x;
            int col = curr.y;
            long eff = curr.effort;
            if (eff > efforts[row][col])
                continue;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= 0 && c >= 0 && r < m && c < n) {
                    long newEff = Math.max(eff, Math.abs(heights[row][col] - heights[r][c]));
                    if (newEff < efforts[r][c]) {
                        efforts[r][c] = newEff;
                        q.offer(new Pair(r, c, efforts[r][c]));
                    }

                }
            }
        }
        return (int) efforts[m - 1][n - 1];
    }
}