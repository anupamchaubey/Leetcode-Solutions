class Solution {
    class Pair {
        int node, w;

        public Pair(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new Pair(v, w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.w;
            if (d > dist[u])
                continue;
            for (Pair p : adj.get(u)) {
                int v = p.node;
                int w = p.w;
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        int min = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            min = Math.max(min, dist[i]);
        }
        return min;
    }
}