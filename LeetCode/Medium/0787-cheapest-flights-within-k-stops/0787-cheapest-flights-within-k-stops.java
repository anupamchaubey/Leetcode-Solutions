class Solution {
    class Pair {
        int node, w;

        public Pair(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            int u = f[0];
            int v = f[1];
            int w = f[2];
            adj.get(u).add(new Pair(v, w));
        }

        int[][] dp = new int[n][k + 2];
        for (int[] dist : dp) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        dp[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { src, 0, 0 }); // node, cost, stops

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int c = curr[1];
            int st = curr[2];
            if (c > dp[u][st])
                continue;
            for (Pair p : adj.get(u)) {
                int v = p.node;
                int ncost = p.w + c;
                int nst = st + 1;
                if (nst <= k + 1 && ncost < dp[v][nst]) {
                    dp[v][nst] = ncost;
                    pq.offer(new int[] { v, ncost, nst });
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, dp[dst][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}