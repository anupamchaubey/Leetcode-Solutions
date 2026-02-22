class Solution {
    class Pair {
        int node, time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int t = e[2];
            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }

        int[][] dp = new int[n][maxTime + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE);
        dp[0][0] = passingFees[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] { 0, passingFees[0], 0 });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int c = curr[1];
            int t = curr[2];
            for (Pair p : adj.get(u)) {
                int v = p.node;
                int nt = t + p.time;
                int nc = c + passingFees[v];
                if (nt <= maxTime && nc < dp[v][nt]) {
                    dp[v][nt] = nc;
                    pq.offer(new int[] { v, nc, nt });
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= maxTime; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}