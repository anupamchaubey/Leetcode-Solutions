class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            max = Math.max(max, bfs(bombs, i, visited));
        }
        return max;
    }

    int bfs(int[][] bombs, int b, boolean[] visited) {

        int blast = 1;

        Queue<Integer> q = new LinkedList<>();
        visited[b] = true;
        q.offer(b);
        while (!q.isEmpty()) {
            int x = q.poll();
            long x1 = bombs[x][0];
            long y1 = bombs[x][1];
            int r1 = bombs[x][2];

            for (int i = 0; i < bombs.length; i++) {
                if (visited[i])
                    continue;
                long x2 = bombs[i][0];
                long y2 = bombs[i][1];
                long r2 = bombs[i][2];
                long sq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

                long rs = (long)r1 * r1;
                if (sq <= rs) {
                    visited[i] = true;
                    blast++;
                    q.offer(i);
                }
            }
        }
        return blast;

    }
}