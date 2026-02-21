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
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0, 0 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            if (stops > k)
                continue;

            for (Pair p : adj.get(u)) {
                int v = p.node;
                int w = p.w;
                if (dist[v] > cost + w) {
                    dist[v] = cost + w;
                    q.offer(new int[] { v, dist[v], stops + 1 });
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}