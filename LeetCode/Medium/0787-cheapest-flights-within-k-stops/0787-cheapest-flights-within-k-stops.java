class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            int u = f[0];
            int v = f[1];
            int c = f[2];
            adj.get(u).add(new int[] { v, c });
        }

        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        // node, cost, stops
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        q.offer(new int[] { src, 0, 0 });
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int u = arr[0];
            int cost = arr[1];
            int stops = arr[2];

            if (stops > k)
                continue;
            if (cost > dist[u][stops])
                continue;
            for (int[] p : adj.get(u)) {
                int v = p[0];
                int price = p[1];
                if (cost + price < dist[v][stops + 1]) {
                    dist[v][stops + 1] = cost + price;
                    q.offer(new int[] { v, dist[v][stops + 1], stops + 1 });
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, dist[dst][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}