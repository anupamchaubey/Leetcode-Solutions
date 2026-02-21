class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    class Pair {
        int r;
        int c;
        int diff;

        public Pair(int r, int c, int diff) {
            this.r = r;
            this.c = c;
            this.diff = diff;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.diff, b.diff));
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        pq.offer(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int diff = curr.diff;
            if (diff > dist[r][c])
                continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int ndiff = Math.max(diff, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (dist[nr][nc] > ndiff) {
                        dist[nr][nc] = ndiff;
                        pq.offer(new Pair(nr, nc, ndiff));
                    }

                }
            }
        }
        return dist[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist[m - 1][n - 1];
    }
}