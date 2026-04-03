class Solution {
    class Pair {
        int v;
        int t;

        Pair(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int ti = t[2];
            adj.get(u).add(new Pair(v, ti));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[0] = -1;
        dist[k] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));

        q.offer(new Pair(k, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int u = p.v;
            if(p.t>dist[u])continue;
            for (Pair pv : adj.get(u)) {
                int v = pv.v;
                if (dist[u] + pv.t < dist[v]) {
                    dist[v] = dist[u] + pv.t;
                    q.offer(new Pair(v, dist[v]));
                }

            }
        }
        int max = 0;
        for (int x : dist)
            max = Math.max(max, x);
        if (max == Integer.MAX_VALUE / 2)
            return -1;

        return max;
    }
}