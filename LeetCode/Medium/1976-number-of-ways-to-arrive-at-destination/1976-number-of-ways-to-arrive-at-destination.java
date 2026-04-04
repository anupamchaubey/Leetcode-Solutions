class Solution {
    class Pair {
        int city;
        int cost;

        Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    int MOD = 1000000007;

    public int countPaths(int n, int[][] roads) {
        long[] dist = new long[n];
        long[] ways = new long[n];
        ways[0] = 1;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int c = r[2];
            adj.get(u).add(new Pair(v, c));
            adj.get(v).add(new Pair(u, c));
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1])); // node, price
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            int u = (int) arr[0];
            long costTillNow = arr[1];
            if (costTillNow > dist[u])
                continue;
            for (Pair p : adj.get(u)) {
                int v = p.city;
                int c = p.cost;
                if (costTillNow + c < dist[v]) {
                    dist[v] = costTillNow + c;
                    ways[v] = ways[u];
                    pq.offer(new long[] { v, dist[v] });
                } else if (costTillNow + c == dist[v]) {
                    ways[v] = (ways[u] + ways[v]) % MOD;
                }
            }
        }
        return (int) ways[n - 1] % MOD;
    }
}